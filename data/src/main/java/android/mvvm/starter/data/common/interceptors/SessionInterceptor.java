package android.mvvm.starter.data.common.interceptors;

import android.mvvm.starter.data.common.constants.Constants;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by EmirHadzimahmutovic on 10/9/2017.
 */

public class SessionInterceptor implements Interceptor {

    @Inject
    public SessionInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader(Constants.AUTH_HEADER, "").build());
    }
}

