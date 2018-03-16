package com.example.ccruzado.cleanarchitecturever2.di.module;

import com.example.ccruzado.cleanarchitecturever2.data.api.ApiRestService;
import com.example.ccruzado.cleanarchitecturever2.data.repository.MultipleResourceRepository;
import com.example.ccruzado.cleanarchitecturever2.data.repository.Repository;
import com.example.ccruzado.cleanarchitecturever2.presentation.MultipleResourceActivityMVP;
import com.example.ccruzado.cleanarchitecturever2.presentation.MultipleResourceModel;
import com.example.ccruzado.cleanarchitecturever2.presentation.MultipleResourcePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ccruzado on 16/03/2018.
 */

@Module
public class MultipleResourceModule {

    @Provides
    public MultipleResourceActivityMVP.Presenter providePresenter(MultipleResourceActivityMVP.Model model) {
        return new MultipleResourcePresenter(model);
    }

    @Provides
    public MultipleResourceActivityMVP.Model provideModel(Repository repository) {
        return new MultipleResourceModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(ApiRestService apiRestService) {
        return new MultipleResourceRepository(apiRestService);
    }

}
