package android.mvvm.starter.data.user.repository;

import android.mvvm.starter.data.common.constants.Constants;
import android.mvvm.starter.data.user.datasource.api.UserApiDataSource;
import android.mvvm.starter.data.user.datasource.cache.UserCacheDataSource;
import android.mvvm.starter.domain.user.models.LoginRequest;
import android.mvvm.starter.domain.user.repository.UserRepository;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;

@Singleton
public class UserRepositoryImpl implements UserRepository {

    private UserApiDataSource userApiDataSource;
    private UserCacheDataSource userCacheDataSource;

    @Inject
    public UserRepositoryImpl(UserApiDataSource userApiDataSource, UserCacheDataSource userCacheDataSource) {
        this.userApiDataSource = userApiDataSource;
        this.userCacheDataSource = userCacheDataSource;
        if (this.userApiDataSource != null && this.userCacheDataSource != null) {
            Log.d(Constants.LOG_TAG, "UserRepositoryImpl INJECTED");
        }
    }

    @Override
    public Completable login(LoginRequest loginRequest) {
        return userApiDataSource.login(loginRequest);
    }
}
