package com.example.ccruzado.cleanarchitecturever2.presentation.interfaces;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;
import com.example.ccruzado.cleanarchitecturever2.presentation.model.MultipleResourceView;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 14/03/2018.
 */

public interface MultipleResourceActivityMVP {

    interface View {

        void MuestraListaMultipleResource(MultipleResourceView multipleResource);
        void Error(String value);
        void showLoading();
        void hideLoading();

    }

    interface Presenter {

        void loadData();
        void rxUnsubscribe();
        void setView(MultipleResourceActivityMVP.View view);

    }

    interface Model {

        Observable<MultipleResourceDomain> result();

    }

}
