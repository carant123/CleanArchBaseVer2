package com.example.ccruzado.cleanarchitecturever2.di.component;

import com.example.ccruzado.cleanarchitecturever2.data.api.ApiRestService;
import com.example.ccruzado.cleanarchitecturever2.di.module.ApplicationModule;
import com.example.ccruzado.cleanarchitecturever2.di.module.NetModule;
import com.example.ccruzado.cleanarchitecturever2.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ccruzado on 14/03/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class, RepositoryModule.class})
public interface ApplicationComponent {

/*    void inject(UsuarioListActivity activity);
    void inject(MultipleResourceListActivity activity);

    void inject(UsuarioApiData databaseapi);
    void inject(MultipleResourceApiData multipleResourceApiData);*/


    ApiRestService getApiService();
}
