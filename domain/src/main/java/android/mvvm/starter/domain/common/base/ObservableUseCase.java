package android.mvvm.starter.domain.common.base;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
/***
 *
 * @param <R> Result
 * @param <P> Params
 */

public abstract class ObservableUseCase<R, P> extends ReactiveUseCase {

    public ObservableUseCase(Scheduler scheduler, Scheduler mainScheduler) {
        super(scheduler, mainScheduler);
    }

    public Disposable execute(DisposableObserver<R> observer, P ... params) {
        return buildUseCaseObservable(params)
                .subscribeOn(scheduler)
                .observeOn(mainScheduler)
                .subscribeWith(observer);
    }

    abstract Observable<R> buildUseCaseObservable(P ... params);
}


