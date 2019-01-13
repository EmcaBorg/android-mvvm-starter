package android.mvvm.starter.data.common.di;

import android.mvvm.starter.data.user.UserDataModule;

import dagger.Module;


@Module(includes = {
        ApiModule.class,
        CacheModule.class,
        SchedulerModule.class,
        UserDataModule.class
})
public abstract class DataModule {

}
