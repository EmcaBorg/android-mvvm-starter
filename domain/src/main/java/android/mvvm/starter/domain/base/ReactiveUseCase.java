package android.mvvm.starter.domain.base;
import io.reactivex.Scheduler;

public abstract class ReactiveUseCase {

    protected Scheduler scheduler;
    protected Scheduler mainScheduler;

    public ReactiveUseCase(Scheduler scheduler, Scheduler mainScheduler) {
        this.scheduler = scheduler;
        this.mainScheduler = mainScheduler;
    }
}
