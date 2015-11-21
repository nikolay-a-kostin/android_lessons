package com.gmail.nikolay_a_kostin.task01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import junit.framework.Assert;

public class RadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio);

		RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radio_activity_group);
		RadioButton[] radiobutton = new RadioButton[ImageView.ScaleType.values().length];
		for (ImageView.ScaleType scaleType : ImageView.ScaleType.values())
		{
			int i = scaleType.ordinal();
			radiobutton[i] = new RadioButton(this);
			radiobutton[i].setText(scaleType.toString());
			radiobutton[i].setTag(scaleType);
			radiogroup.addView(radiobutton[i]);
		}
		radiogroup.setOnCheckedChangeListener(this);
		radiobutton[0].setChecked(true);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		ImageView.ScaleType scaleType = (ImageView.ScaleType) group.findViewById(checkedId).getTag();
		((ImageView) findViewById(R.id.radio_activity_image)).setScaleType(scaleType);
	}
}
