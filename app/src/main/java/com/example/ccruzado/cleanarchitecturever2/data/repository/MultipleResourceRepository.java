package com.example.ccruzado.cleanarchitecturever2.data.repository;

import android.util.Log;

import com.example.ccruzado.cleanarchitecturever2.data.api.ApiRestService;
import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.data.model.mapper.MultipleResourceModelMapper;
import com.example.ccruzado.cleanarchitecturever2.data.repository.interfaces.MultipleResourceIRepository;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by ccruzado on 16/03/2018.
 */

public class MultipleResourceRepository implements MultipleResourceIRepository {

    ApiRestService apiRestService;

    private List<MultipleResourceDomain> results;
    private long timestamp;
    private static final long STALE_MS = 10 * 1000; // Data is stale after 20 seconds
    private MultipleResourceModelMapper multipleResourceModelMapper;


    public MultipleResourceRepository(ApiRestService apiRestService, MultipleResourceModelMapper multipleResourceModelMapper) {
        this.apiRestService = apiRestService;
        this.multipleResourceModelMapper = multipleResourceModelMapper;
        results = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<MultipleResourceDomain> getResultsFromMemory() {

        if (isUpToDate()) {
            Log.d("data1","data1");
            return Observable.fromIterable(results);
        } else {
            Log.d("data2","data2");
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<MultipleResourceDomain> getResultsFromNetwork() {

        Observable<MultipleResourceDomain> multipleResourceObservable =
                apiRestService.listMultiple().map(new Function<MultipleResourceData, MultipleResourceDomain>() {
                    @Override
                    public MultipleResourceDomain apply(MultipleResourceData multipleResourceData) throws Exception {
                        return multipleResourceModelMapper.reverseMap(multipleResourceData);
                    }
                });


        return multipleResourceObservable.doOnNext(new Consumer<MultipleResourceDomain>() {
            @Override
            public void accept(MultipleResourceDomain multipleResource) throws Exception {
                results.add(multipleResource);
            }
        });



    }

    @Override
    public Observable<MultipleResourceDomain> listMultiple() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }


}
