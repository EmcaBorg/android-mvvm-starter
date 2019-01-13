package android.mvvm.starter.common.di.modules;

import android.app.Application;
import android.content.Context;
import android.mvvm.starter.BuildConfig;
import android.mvvm.starter.common.di.components.LoginActivityComponent;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
        LoginActivityComponent.class
})
public class ApplicationModule {

    @Provides
    @Singleton
    @Named("ApplicationContext")
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Named("DatabaseName")
    String provideDatabaseName() {
        return "android-mvvm-starter.realm";
    }

    @Provides
    @Named("DatabaseVersion")
    int provideDatabaseVersion() {
        return 1;
    }

    @Provides
    @Named("DatabaseSQLiteName")
    String provideDatabaseSQLiteName() {
        return "android-mvvm-starter";
    }

    @Provides
    @Named("DatabaseSQLiteVersion")
    int provideDatabaseSQLiteVersion() {
        return 1;
    }

    @Provides
    @Named("BaseUrl")
    String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    @Named("WebSocketUrl")
    String provideWebSocketUrl() {
        return BuildConfig.WEBSOCKET;
    }

}
