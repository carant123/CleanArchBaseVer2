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
    private Subscription subscription = null;
    private MultipleResourceActivityMVP.Model model;

    CompositeDisposable compositeDisposable;
    DisposableObserver observer;

    public MultipleResourcePresenter(MultipleResourceActivityMVP.Model model) {
        this.model = model;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadData() {

 /*       observer = model
                .result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MultipleResource>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MultipleResource multipleResource) {
                        if (view != null) {
                            view.MuestraListaMultipleResource(multipleResource);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {

                        }
                    }

                    @Override
                    public void onComplete() {

                    }

                });

        compositeDisposable.add(observer);*/

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
