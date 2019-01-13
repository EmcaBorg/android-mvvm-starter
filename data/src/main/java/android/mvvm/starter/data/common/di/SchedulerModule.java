package android.mvvm.starter.data.common.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class SchedulerModule {

    @Provides
    @Singleton
    @Named("MAIN")
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named("IO")
    Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named("COMPUTATION")
    Scheduler provideComputationScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named("TRAMPOLINE")
    Scheduler provideTrampolineScheduler() {
        return Schedulers.trampoline();
    }

}

