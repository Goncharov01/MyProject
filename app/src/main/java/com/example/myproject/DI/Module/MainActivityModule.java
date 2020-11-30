package com.example.myproject.DI.Module;

import com.example.myproject.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModules.class)
    abstract MainActivity contributesMainActivity();


}
