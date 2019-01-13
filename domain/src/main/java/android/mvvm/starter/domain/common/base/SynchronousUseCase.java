package android.mvvm.starter.domain.common.base;

/***
 *
 * @param <R> Result
 * @param <P> Params
 */

public abstract class SynchronousUseCase<R, P> {

    public R execute(P... params) {
        return buildSynchronousUseCase(params);
    }

    abstract R buildSynchronousUseCase(P... params);
}
