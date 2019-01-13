package android.mvvm.starter.data.user;

import android.mvvm.starter.data.user.datasource.api.UserApiDataSource;
import android.mvvm.starter.data.user.datasource.cache.UserCacheDataSource;
import android.mvvm.starter.data.user.datasource.cache.UserCacheDataSourceImpl;
import android.mvvm.starter.data.user.repository.UserRepositoryImpl;
import android.mvvm.starter.domain.user.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class UserDataModule {

    @Binds
    @Singleton
    public abstract UserRepository provideUserRepository(UserRepositoryImpl userRepository);

    @Binds
    @Singleton
    public abstract UserCacheDataSource provideUserCacheDataSource(UserCacheDataSourceImpl userCacheDataSource);


    @Provides
    public static UserApiDataSource provideUserApiDataSource(Retrofit retrofit) {
        return retrofit.create(UserApiDataSource.class);
    }

}
