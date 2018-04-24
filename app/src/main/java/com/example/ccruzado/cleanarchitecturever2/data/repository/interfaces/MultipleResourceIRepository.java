package com.example.ccruzado.cleanarchitecturever2.data.repository.interfaces;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 16/03/2018.
 */

public interface MultipleResourceIRepository {

    Observable<MultipleResourceDomain> listMultiple();

    Observable<MultipleResourceDomain> getResultsFromMemory();

    Observable<MultipleResourceDomain> getResultsFromNetwork();

}
