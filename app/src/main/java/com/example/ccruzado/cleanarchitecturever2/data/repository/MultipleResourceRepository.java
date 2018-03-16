package com.example.ccruzado.cleanarchitecturever2.data.repository;

import android.util.Log;

import com.example.ccruzado.cleanarchitecturever2.StartApplication;
import com.example.ccruzado.cleanarchitecturever2.data.api.ApiRestService;
import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResource;

import java.util.ArrayList;
import java.util.List;

import static com.example.ccruzado.cleanarchitecturever2.StartApplication.getComponent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by ccruzado on 16/03/2018.
 */

public class MultipleResourceRepository implements Repository {

    ApiRestService apiRestService;

    private List<MultipleResource> results;
    private long timestamp;
    private static final long STALE_MS = 10 * 1000; // Data is stale after 20 seconds


    public MultipleResourceRepository(ApiRestService apiRestService) {
        this.apiRestService = apiRestService;
        results = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<MultipleResource> getResultsFromMemory() {

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
    public Observable<MultipleResource> getResultsFromNetwork() {

        Observable<MultipleResource> multipleResourceObservable = apiRestService.listMultiple();

        return multipleResourceObservable.doOnNext(new Consumer<MultipleResource>() {
            @Override
            public void accept(MultipleResource multipleResource) throws Exception {
                results.add(multipleResource);
            }
        });
    }

    @Override
    public Observable<MultipleResource> listMultiple() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }


}
