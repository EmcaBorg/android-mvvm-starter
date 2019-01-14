package android.mvvm.starter.base.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.mvvm.starter.common.constants.Constants;
import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            Log.d(Constants.LOG_TAG, "dispose()");
        }
    }
}
