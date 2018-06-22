package com.urancompany.exhibitions.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.urancompany.exhibitions.R;
import com.urancompany.model.Exhibit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends ArrayAdapter<Exhibit> {

    MainAdapter(@NonNull Context context, List<Exhibit> exhibitList) {
        super(context, 0, exhibitList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exhibit_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Exhibit item = getItem(position);

        if (item != null) {
            holder.mTitle.setText(item.getTitle());
            holder.mPager.setAdapter(new CustomPagerAdapter(parent.getContext(), item.getImages()));
        }

        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.pager)
        ViewPager mPager;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
