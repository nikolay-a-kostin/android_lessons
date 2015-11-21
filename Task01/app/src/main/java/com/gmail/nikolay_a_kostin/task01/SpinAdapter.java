package com.gmail.nikolay_a_kostin.task01;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by master on 14.11.2015.
 */
public class SpinAdapter extends BaseAdapter {
    Activity _activity;
    String[] _values;

    SpinAdapter(Activity activity, String[] values)
    {
        _activity = activity;
        _values = values;
    }

    @Override
    public int getCount() {
        return _values.length;
    }

    @Override
    public Object getItem(int position) {
        return _values[position];
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = _activity.getLayoutInflater().inflate(R.layout.activity_spin_item, null, false);
            convertView.setTag(new Holder(convertView));
        }
        Holder holder = (Holder) convertView.getTag();
        holder._textView.setText(_values[position]);
        convertView.setTag(holder);
        return convertView;
    }

    public static class Holder
    {
        View _parent;
        TextView _textView;

        public Holder(View parent)
        {
            _parent = parent;
            _textView = (TextView) _parent.findViewById(R.id.textView);
        }
    }
}
