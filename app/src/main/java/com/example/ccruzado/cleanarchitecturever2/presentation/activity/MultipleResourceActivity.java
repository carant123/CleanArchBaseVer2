package com.example.ccruzado.cleanarchitecturever2.presentation.activity;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ccruzado.cleanarchitecturever2.R;
import com.example.ccruzado.cleanarchitecturever2.StartApplication;
import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.presentation.interfaces.MultipleResourceActivityMVP;
import com.example.ccruzado.cleanarchitecturever2.presentation.adapter.MultipleResourceAdapter;
import com.example.ccruzado.cleanarchitecturever2.presentation.base.BaseActivity;
import com.example.ccruzado.cleanarchitecturever2.presentation.model.MultipleResourceView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by ccruzado on 14/03/2018.
 */

public class MultipleResourceActivity extends BaseActivity implements MultipleResourceActivityMVP.View {


    @BindView(R.id.recycleViewList)
    RecyclerView recyclerView;

    @BindView(R.id.progress_recycle)
    ProgressBar progress_recycle;

    @Inject
    MultipleResourceActivityMVP.Presenter presenter;

    private Context mContext;
    private MultipleResourceAdapter multipleResourceAdapter;
    private ArrayList<MultipleResourceView> multipleResource = new ArrayList<MultipleResourceView>();
    private static final String TAG = MultipleResourceActivity.class.getSimpleName();


    @Override
    protected int getLayoutId() {
        return R.layout.recycleview_layout;
    }


    @Override
    protected void init() {

        this.mContext = getApplicationContext();
        ((StartApplication) getApplication()).getComponent().inject(this);

        multipleResourceAdapter = new MultipleResourceAdapter(multipleResource,this.mContext);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this.mContext);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(this.multipleResourceAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }


    @Override
    public void MuestraListaMultipleResource(MultipleResourceView mrValue) {

        multipleResource.add(mrValue);
        multipleResourceAdapter.notifyItemInserted(multipleResource.size() - 1);

    }

    @Override
    public void Error(String value) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT);
    }

    @Override
    public void showLoading() {
        progress_recycle.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progress_recycle.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        multipleResource.clear();
        multipleResourceAdapter.notifyDataSetChanged();
    }

}
