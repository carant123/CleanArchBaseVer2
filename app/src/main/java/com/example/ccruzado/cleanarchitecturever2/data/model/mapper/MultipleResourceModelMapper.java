package com.example.ccruzado.cleanarchitecturever2.data.model.mapper;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;
import com.example.ccruzado.cleanarchitecturever2.presentation.model.MultipleResourceView;

import javax.inject.Inject;

/**
 * Created by ccruzado on 21/03/2018.
 */

public class MultipleResourceModelMapper extends Mapper<MultipleResourceDomain,MultipleResourceData> {


    @Inject
    public MultipleResourceModelMapper() {
    }

    @Override
    public MultipleResourceData map(MultipleResourceDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultipleResourceDomain reverseMap(MultipleResourceData value) {

        MultipleResourceDomain multipleResourceDomain = new MultipleResourceDomain();
        multipleResourceDomain.setPage(value.getPage());
        multipleResourceDomain.setPerPage(value.getPerPage());
        multipleResourceDomain.setTotal(value.getTotal());
        multipleResourceDomain.setTotalPages(value.getTotalPages());

        return multipleResourceDomain;
    }

}
