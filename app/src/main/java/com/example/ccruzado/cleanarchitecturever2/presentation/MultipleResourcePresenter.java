package com.example.ccruzado.cleanarchitecturever2.presentation;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResource;

import org.reactivestreams.Subscription;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
    private DisposableObserver<MultipleResource> disposableObserver_model;
    private Observable<MultipleResource> observable;

    public MultipleResourcePresenter(MultipleResourceActivityMVP.Model model) {
        this.model = model;
        compositeDisposable = new CompositeDisposable();

    }

    @Override
    public void loadData() {

        view.showLoading();

        observable = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        disposableObserver_model = new DisposableObserver<MultipleResource>() {

            @Override
            public void onNext(MultipleResource multipleResource) {
                if (view != null) {
                    view.MuestraListaMultipleResource(multipleResource);
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
