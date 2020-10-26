package com.example.myproject.DI.Module;

import com.example.myproject.MainActivity;
import com.example.myproject.retrofit.DeleteListener;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModules {

    @Binds
    abstract DeleteListener deleteListener(MainActivity mainActivity);

}
