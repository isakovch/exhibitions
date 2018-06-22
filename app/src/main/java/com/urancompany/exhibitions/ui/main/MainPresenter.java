package com.urancompany.exhibitions.ui.main;

import com.urancompany.model.ExhibitsLoader;

public class MainPresenter implements MainContract.Presenter {

    private ExhibitsLoader mLoader;
    private MainContract.View mView;

    MainPresenter(ExhibitsLoader loader) {
        this.mLoader = loader;
    }

    @Override
    public void loadData() {
        mView.showLoadingIndicator();
        mView.displayData(mLoader.getExhibitList());
        mView.hideLoadingIndicator();
    }

    @Override
    public void bind(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void unbind() {
        this.mView = null;
    }
}
