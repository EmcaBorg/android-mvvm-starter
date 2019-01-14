package android.mvvm.starter.domain.base;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;

public abstract class CompletableUseCase<P> extends ReactiveUseCase {

    public CompletableUseCase(Scheduler scheduler, Scheduler mainScheduler) {
        super(scheduler, mainScheduler);
    }

    public Disposable execute(DisposableCompletableObserver observer, P ... params) {
        return buildUseCaseCompletable(params)
                .subscribeOn(scheduler)
                .observeOn(mainScheduler)
                .subscribeWith(observer);
    }

    protected abstract Completable buildUseCaseCompletable(P ... params);
}