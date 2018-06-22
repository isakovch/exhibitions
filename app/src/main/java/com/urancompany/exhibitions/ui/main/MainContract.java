package com.urancompany.exhibitions.ui.main;

import com.urancompany.exhibitions.ui.ILifecycle;
import com.urancompany.exhibitions.ui.IProgressBar;
import com.urancompany.model.Exhibit;

import java.util.List;

public interface MainContract {

    interface View extends IProgressBar {
        void displayData(List<Exhibit> exhibitList);

        void showError(String error);
    }

    interface Presenter extends ILifecycle<View> {
        void loadData();
    }

}
