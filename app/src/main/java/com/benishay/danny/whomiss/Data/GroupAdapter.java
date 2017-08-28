package com.benishay.danny.whomiss.Data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.benishay.danny.whomiss.R;

/**
 * Created by Dan on 28/08/2017.
 */

public class GroupAdapter extends ArrayAdapter<MyGroups> {
    public GroupAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_add_group, parent, false);
        }
        TextView tvGroupName = (TextView) convertView.findViewById(R.id.etGroupName);
        TextView tvSchoolName = (TextView) convertView.findViewById(R.id.etSchoolName);

        MyGroups myGroup = getItem(position);

        tvGroupName.setText(myGroup.getName());
        tvSchoolName.setText(myGroup.getSchoolName());

        return convertView;
    }
}
