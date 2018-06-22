package com.urancompany.loader;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.urancompany.model.Exhibit;
import com.urancompany.model.ExhibitsLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileExhibitsLoader implements ExhibitsLoader {

    private Context mContext;

    public FileExhibitsLoader(Context context) {
        this.mContext = context;
    }

    @Override
    public List<Exhibit> getExhibitList() {
        ExhibitItem item = new Gson().fromJson(loadDataFromAssets(), ExhibitItem.class);
        return item.getExhibitList();
    }

    private String loadDataFromAssets() {
        String json;
        try {
            InputStream is = mContext.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private class ExhibitItem {
        @SerializedName("list")
        private List<Exhibit> exhibitList;

        List<Exhibit> getExhibitList() {
            return exhibitList;
        }
    }

}
