package com.example.ccruzado.cleanarchitecturever2.presentation.presenter;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;
import com.example.ccruzado.cleanarchitecturever2.presentation.interfaces.MultipleResourceActivityMVP;
import com.example.ccruzado.cleanarchitecturever2.presentation.model.mapper.MultipleResourceModelMapper;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ccruzado on 14/03/2018.
 */

public class MultipleResourcePresenter implements MultipleResourceActivityMVP.Presenter {

    private MultipleResourceActivityMVP.View view;
    private MultipleResourceActivityMVP.Model model;


    private CompositeDisposable compositeDisposable;
    private DisposableObserver disposableObserver;
    private DisposableObserver<MultipleResourceDomain> disposableObserver_model;
    private Observable<MultipleResourceDomain> observable;
    private MultipleResourceModelMapper mapper;

    public MultipleResourcePresenter(MultipleResourceActivityMVP.Model model, MultipleResourceModelMapper mapper) {
        this.model = model;
        this.mapper = mapper;
        compositeDisposable = new CompositeDisposable();

    }



    @Override
    public void loadData() {

        view.showLoading();

        observable = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        disposableObserver_model = new DisposableObserver<MultipleResourceDomain>() {

            @Override
            public void onNext(MultipleResourceDomain multipleResource) {
                if (view != null) {

                    view.MuestraListaMultipleResource(mapper.reverseMap(multipleResource));
                    view.hideLoading();
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (view != null) {
                    view.Error("No hay valores");
                    view.hideLoading();
                }
            }

            @Override
            public void onComplete() {

            }
        };

        disposableObserver = observable.subscribeWith(disposableObserver_model);
        compositeDisposable.add(disposableObserver);

    }

    @Override
    public void rxUnsubscribe() {

        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }

    }

    @Override
    public void setView(MultipleResourceActivityMVP.View view) {
        this.view = view;
    }
}
