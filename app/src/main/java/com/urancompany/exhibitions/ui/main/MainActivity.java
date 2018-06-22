package com.urancompany.exhibitions.ui.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;
import com.urancompany.exhibitions.R;
import com.urancompany.exhibitions.ui.BaseActivity;
import com.urancompany.exhibitions.utils.MsgUtils;
import com.urancompany.loader.FileExhibitsLoader;
import com.urancompany.model.Exhibit;

import java.util.List;

import javax.xml.transform.sax.TemplatesHandler;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.list_view)
    ListView mListView;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(new FileExhibitsLoader(this));
        mPresenter.bind(this);
        mPresenter.loadData();
    }

    @Override
    public void displayData(List<Exhibit> exhibitList) {
        mListView.setAdapter(new MainAdapter(this, exhibitList));
    }

    @Override
    public void showError(String error) {
        MsgUtils.showShortToast(this, error);
    }

    @Override
    public void showLoadingIndicator() {
        showProgressBar();
    }

    @Override
    public void hideLoadingIndicator() {
        hideProgressBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
}
