package android.mvvm.starter.data.common.di;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.mvvm.starter.data.common.constants.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(Application application) {
        return application.getSharedPreferences(Constants.PREF_TAG, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor provideSharedPrefsEditor(SharedPreferences sharedPreferences) {
        return sharedPreferences.edit();
    }


}
