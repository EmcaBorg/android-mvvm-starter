package android.mvvm.starter.data.common.interceptors;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ForbiddenInterceptor implements Interceptor {

    @Inject
    public ForbiddenInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (response.code() == 403) {

        }
        return response;
    }
}
