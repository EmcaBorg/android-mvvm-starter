package android.mvvm.starter.common.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.mvvm.starter.common.di.scopes.ViewModelKey;
import android.mvvm.starter.common.factories.ViewModelFactory;
import android.mvvm.starter.user.UserViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel userViewModel(UserViewModel userViewModel);


}