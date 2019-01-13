package android.mvvm.starter.user;

import android.arch.lifecycle.ViewModelProviders;
import android.mvvm.starter.R;
import android.mvvm.starter.common.factories.ViewModelFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
    }
}
