package android.mvvm.starter.common.di.modules;
import android.app.Activity;
import android.mvvm.starter.user.LoginActivity;
import android.mvvm.starter.common.di.components.LoginActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindLoginActivity(LoginActivityComponent.Builder builder);


}
