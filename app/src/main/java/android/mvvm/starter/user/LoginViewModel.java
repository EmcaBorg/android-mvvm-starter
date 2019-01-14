package android.mvvm.starter.user;

import android.arch.lifecycle.MutableLiveData;
import android.mvvm.starter.base.viewmodel.BaseViewModel;
import android.mvvm.starter.common.constants.Constants;
import android.mvvm.starter.domain.user.models.LoginRequest;
import android.mvvm.starter.domain.user.usecase.LoginUseCase;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

public class LoginViewModel extends BaseViewModel {

    private LoginUseCase loginUseCase;

    public MutableLiveData<String> domain = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setDomainName(domain.getValue());
        loginRequest.setUsername(username.getValue());
        loginRequest.setPassword(password.getValue());
        compositeDisposable.add(loginUseCase.execute(new DisposableCompletableObserver() {
            @Override
            public void onComplete() {
                Log.d(Constants.LOG_TAG, String.format("LoginRequest - domain: %s username: %s password: %s ", loginRequest.getDomainName(), loginRequest.getUsername(), loginRequest.getPassword()));
            }
            @Override
            public void onError(Throwable e) {
               Log.d(Constants.LOG_TAG, e.getMessage());
            }
        }, loginRequest));
    }
}
