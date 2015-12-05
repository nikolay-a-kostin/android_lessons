package com.gmail.nikolay_a_kostin.task02;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by nkostin on 21.11.2015.
 */
public class MainAdapter extends BaseAdapter
{
	Activity _activity;
	String[] _values;

	MainAdapter(Activity activity, String[] values)
	{
		_activity = activity;
		_values = values;
	}

	@Override
	public int getCount() {
		return _values.length / 3;
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
			convertView = _activity.getLayoutInflater().inflate(R.layout.activity_main_item, null, false);
			convertView.setTag(new Holder(convertView));
		}
		Holder holder = (Holder) convertView.getTag();
		holder.textName.setText(_values[position * 3]);
		holder.textInfo.setText(_values[position * 3 + 1]);

		String a = _values[position * 3 + 2];
		Picasso.with(_activity.getApplicationContext())
				.load(_values[position * 3 + 2])
				.placeholder(R.drawable.placeholder)
				.into(holder.imageView);
		return convertView;
	}

	public static class Holder
	{
		View _parent;
		ImageView imageView;
		TextView textName;
		TextView textInfo;

		public Holder(View parent)
		{
			_parent = parent;
			imageView = (ImageView) _parent.findViewById(R.id.imageView);
			textName = (TextView) _parent.findViewById(R.id.textName);
			textInfo = (TextView) _parent.findViewById(R.id.textInfo);
		}
	}
}
