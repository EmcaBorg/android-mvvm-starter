package android.mvvm.starter.domain.base;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
/***
 *
 * @param <R> Result
 * @param <P> Params
 */

public abstract class SingleUseCase<R, P> extends ReactiveUseCase {

    public SingleUseCase(Scheduler scheduler, Scheduler mainScheduler) {
        super(scheduler, mainScheduler);
    }

    public Disposable execute(DisposableSingleObserver<R> observer, P ... params) {
        return buildUseCaseSingle(params)
                 .subscribeOn(scheduler)
                 .observeOn(mainScheduler)
                 .subscribeWith(observer);
    }

    abstract Single<R> buildUseCaseSingle(P ... params);
}
