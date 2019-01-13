package android.mvvm.starter.data.common.di;
import android.content.Context;
import android.mvvm.starter.data.common.constants.Constants;
import android.mvvm.starter.data.common.interceptors.ForbiddenInterceptor;
import android.mvvm.starter.data.common.interceptors.SessionInterceptor;
import android.mvvm.starter.data.common.utils.ByteArrayToBase64TypeAdapter;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmObject;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    Cache provideCacheForOkHTTP(@Named("ApplicationContext") Context context) {
        return new Cache(context.getCacheDir(), Constants.CACHE_FOR_OKHTTP);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        }).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeHierarchyAdapter(byte[].class,
                new ByteArrayToBase64TypeAdapter()).create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(@Named("ApplicationContext") Context context, Cache cache, SessionInterceptor sessionInterceptor, ForbiddenInterceptor forbiddenInterceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        client.addInterceptor(sessionInterceptor);
        client.addInterceptor(forbiddenInterceptor);
        client.connectTimeout(60, TimeUnit.SECONDS);
        client.writeTimeout(60, TimeUnit.SECONDS);
        client.readTimeout(60, TimeUnit.SECONDS);
        client.pingInterval(1, TimeUnit.SECONDS);
        return client.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named("BaseUrl") String baseUrl, Gson gson, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();
        }

}
