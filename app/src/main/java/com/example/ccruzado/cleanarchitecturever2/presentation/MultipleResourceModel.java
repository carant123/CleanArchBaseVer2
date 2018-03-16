package com.example.ccruzado.cleanarchitecturever2.presentation;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResource;
import com.example.ccruzado.cleanarchitecturever2.data.repository.Repository;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 14/03/2018.
 */

public class MultipleResourceModel implements MultipleResourceActivityMVP.Model {

    private Repository repository;

    public MultipleResourceModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<MultipleResource> result() {
        return this.repository.listMultiple();
    }


}
