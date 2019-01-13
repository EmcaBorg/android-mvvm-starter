package android.mvvm.starter.common.di.components;

import android.app.Application;
import android.mvvm.starter.StarterApp;
import android.mvvm.starter.common.di.modules.ActivityBuilder;
import android.mvvm.starter.common.di.modules.ApplicationModule;
import android.mvvm.starter.common.di.modules.KeystoreModule;
import android.mvvm.starter.common.di.modules.ViewModelModule;
import android.mvvm.starter.data.common.di.DataModule;
import android.mvvm.starter.domain.common.di.DomainModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        KeystoreModule.class,
        DomainModule.class,
        DataModule.class,
        ActivityBuilder.class,
        ViewModelModule.class})
public interface ApplicationComponent extends AndroidInjector<StarterApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
    void inject(StarterApp app);
}