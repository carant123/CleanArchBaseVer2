package com.example.ccruzado.cleanarchitecturever2.di.module;

import com.example.ccruzado.cleanarchitecturever2.data.api.ApiRestService;
import com.example.ccruzado.cleanarchitecturever2.data.repository.interfaces.MultipleResourceIRepository;
import com.example.ccruzado.cleanarchitecturever2.data.repository.MultipleResourceRepository;
import com.example.ccruzado.cleanarchitecturever2.presentation.interfaces.MultipleResourceActivityMVP;
import com.example.ccruzado.cleanarchitecturever2.domain.MultipleResourceModel;
import com.example.ccruzado.cleanarchitecturever2.presentation.model.mapper.MultipleResourceModelMapper;
import com.example.ccruzado.cleanarchitecturever2.presentation.presenter.MultipleResourcePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ccruzado on 16/03/2018.
 */

@Module
public class MultipleResourceModule {

    @Provides
    public MultipleResourceActivityMVP.Presenter providePresenter(MultipleResourceActivityMVP.Model model, MultipleResourceModelMapper mapper) {
        return new MultipleResourcePresenter(model,mapper);
    }

    @Provides
    public MultipleResourceActivityMVP.Model provideModel(MultipleResourceIRepository repository) {
        return new MultipleResourceModel(repository);
    }

    @Singleton
    @Provides
    public MultipleResourceIRepository provideRepo(ApiRestService apiRestService, com.example.ccruzado.cleanarchitecturever2.data.model.mapper.MultipleResourceModelMapper mapper) {
        return new MultipleResourceRepository(apiRestService,mapper);
    }

}
