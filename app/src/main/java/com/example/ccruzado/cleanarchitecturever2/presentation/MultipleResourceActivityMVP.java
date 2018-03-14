package com.example.ccruzado.cleanarchitecturever2.presentation;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResource;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 14/03/2018.
 */

public interface MultipleResourceActivityMVP {

    interface View {

        void MuestraListaMultipleResource(MultipleResource multipleResource);
        void showLoading();
        void hideLoading();

    }

    interface Presenter {

        void loadData();
        void rxUnsubscribe();
        void setView(MultipleResourceActivityMVP.View view);

    }

    interface Model {

        Observable<MultipleResource> result();

    }

}
