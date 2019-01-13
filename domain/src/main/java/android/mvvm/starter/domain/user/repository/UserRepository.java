package android.mvvm.starter.domain.user.repository;

import android.mvvm.starter.domain.user.models.LoginRequest;

import io.reactivex.Completable;
public interface UserRepository {

    Completable login(LoginRequest loginRequest);

}
