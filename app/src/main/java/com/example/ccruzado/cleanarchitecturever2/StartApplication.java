package com.example.ccruzado.cleanarchitecturever2;

import android.app.Application;


import com.example.ccruzado.cleanarchitecturever2.di.component.ApplicationComponent;
import com.example.ccruzado.cleanarchitecturever2.di.component.DaggerApplicationComponent;
import com.example.ccruzado.cleanarchitecturever2.di.module.ApplicationModule;
import com.example.ccruzado.cleanarchitecturever2.di.module.MultipleResourceModule;
import com.example.ccruzado.cleanarchitecturever2.di.module.NetModule;
import com.example.ccruzado.cleanarchitecturever2.di.module.RepositoryModule;

/**
 * Created by ccruzado on 14/03/2018.
 */

public class StartApplication extends Application {

    private static StartApplication sInstance;
    private static ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    public static synchronized StartApplication getInstance() {
        return sInstance;
    }


    private void initializeInjector() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule())
                .repositoryModule(new RepositoryModule())
                .multipleResourceModule(new MultipleResourceModule())
                .build();

    }

    public static ApplicationComponent getComponent(){
        return appComponent;
    }




}
