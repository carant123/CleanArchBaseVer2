package com.example.ccruzado.cleanarchitecturever2.domain;

import com.example.ccruzado.cleanarchitecturever2.data.repository.interfaces.MultipleResourceIRepository;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;
import com.example.ccruzado.cleanarchitecturever2.presentation.interfaces.MultipleResourceActivityMVP;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 14/03/2018.
 */

public class MultipleResourceModel implements MultipleResourceActivityMVP.Model {

    private MultipleResourceIRepository repository;

    public MultipleResourceModel(MultipleResourceIRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<MultipleResourceDomain> result() {
        return this.repository.listMultiple();
    }

}
