package android.mvvm.starter.domain.user.usecase;

import android.mvvm.starter.domain.common.base.CompletableUseCase;
import android.mvvm.starter.domain.user.models.LoginRequest;
import android.mvvm.starter.domain.user.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Completable;
import io.reactivex.Scheduler;

public class LoginUseCase extends CompletableUseCase<LoginRequest> {

    private UserRepository userRepository;

    @Inject
    public LoginUseCase(UserRepository userRepository, @Named("IO") Scheduler scheduler, @Named("MAIN") Scheduler mainScheduler) {
        super(scheduler, mainScheduler);
        this.userRepository = userRepository;
    }

    @Override
    protected Completable buildUseCaseCompletable(LoginRequest... params) {
        return userRepository.login(params[0]);
    }
}
