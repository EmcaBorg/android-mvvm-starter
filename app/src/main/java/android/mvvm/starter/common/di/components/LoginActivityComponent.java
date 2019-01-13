package android.mvvm.starter.common.di.components;
import android.mvvm.starter.common.di.modules.ActivityModule;
import android.mvvm.starter.user.LoginActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
@Subcomponent(modules = ActivityModule.class)
public interface LoginActivityComponent extends AndroidInjector<LoginActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginActivity>{}
}