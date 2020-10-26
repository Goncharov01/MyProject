package com.example.myproject.DI.Module;

import androidx.lifecycle.ViewModelProviders;

import com.example.myproject.MainActivity;
import com.example.myproject.MainViewModel;
import com.example.myproject.retrofit.ModelBook;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Singleton
    @Provides
    public ModelBook getModel(){
        return new ModelBook();
    }

//    @Singleton
//    @Provides
//    public MainViewModel getViewModel(MainActivity mainActivity){
//        return ViewModelProviders.of(mainActivity).get(MainViewModel.class);
//
//    }

}