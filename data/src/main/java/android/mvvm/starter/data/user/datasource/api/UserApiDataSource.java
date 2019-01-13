package android.mvvm.starter.data.user.datasource.api;
import android.mvvm.starter.domain.user.models.LoginRequest;

import io.reactivex.Completable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApiDataSource {

    @POST("/api/v1/login")
    Completable login(@Body LoginRequest request);

}