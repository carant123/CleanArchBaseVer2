package com.example.ccruzado.cleanarchitecturever2.presentation.model.mapper;

import com.example.ccruzado.cleanarchitecturever2.data.model.mapper.Mapper;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;
import com.example.ccruzado.cleanarchitecturever2.presentation.model.MultipleResourceView;

import javax.inject.Inject;

/**
 * Created by ccruzado on 21/03/2018.
 */

public class MultipleResourceModelMapper extends Mapper<MultipleResourceView,MultipleResourceDomain> {


    @Inject
    public MultipleResourceModelMapper() {
    }

    @Override
    public MultipleResourceDomain map(MultipleResourceView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultipleResourceView reverseMap(MultipleResourceDomain value) {

        MultipleResourceView multipleResourceView = new MultipleResourceView();
        multipleResourceView.setPage(value.getPage());
        multipleResourceView.setPerPage(value.getPerPage());
        multipleResourceView.setTotal(value.getTotal());
        multipleResourceView.setTotalPages(value.getTotalPages());

        return multipleResourceView;
    }



}
