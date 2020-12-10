package com.example.myproject.DI.Component;

import android.app.Application;

import com.example.myproject.App;
import com.example.myproject.DI.Module.MainActivityModule;
import com.example.myproject.DI.Module.MainModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, MainActivityModule.class, MainModule.class})
public interface MyComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        MyComponent build();
    }

    void inject(App app);

}
