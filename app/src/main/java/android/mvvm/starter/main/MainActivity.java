package android.mvvm.starter.main;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.mvvm.starter.R;
import android.mvvm.starter.base.activity.BaseActivity;
import android.mvvm.starter.common.factories.ViewModelFactory;
import android.mvvm.starter.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        MainViewModel mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mainViewModel);
        binding.setLifecycleOwner(this);
    }
}
