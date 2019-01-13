package android.mvvm.starter.user;

import android.arch.lifecycle.ViewModel;
import android.mvvm.starter.common.constants.Constants;
import android.mvvm.starter.domain.user.usecase.LoginUseCase;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

public class UserViewModel extends ViewModel {

    @Inject
    public UserViewModel(LoginUseCase loginUseCase) {
        /***
         loginUseCase.execute(new DisposableCompletableObserver() {
        @Override public void onComplete() {
        Log.d(Constants.LOG_TAG, "COMPLETED");
        }
        @Override public void onError(Throwable e) {
        }
        });
         ***/
    }
}
