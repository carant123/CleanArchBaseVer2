package com.example.ccruzado.cleanarchitecturever2.data.repository;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResource;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 16/03/2018.
 */

public interface Repository {

    Observable<MultipleResource> listMultiple();

    Observable<MultipleResource> getResultsFromMemory();

    Observable<MultipleResource> getResultsFromNetwork();

}
