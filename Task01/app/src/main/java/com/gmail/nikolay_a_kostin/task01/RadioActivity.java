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

public class RadioActivity extends AppCompatActivity implements View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio);

		RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);

		String[] scale_str = getResources().getStringArray(R.array.scale);
		Assert.assertTrue("Fix it!", scale_str.length == ImageView.ScaleType.values().length);

		RadioButton[] radiobutton = new RadioButton[ImageView.ScaleType.values().length];
		for (ImageView.ScaleType scaleType : ImageView.ScaleType.values())
		{
			int i = scaleType.ordinal();
			radiobutton[i] = new RadioButton(this);
			radiobutton[i].setText(scale_str[i]);
			radiobutton[i].setTag(new Integer(i + 100));
			radiogroup.addView(radiobutton[i]);
			radiobutton[i].setOnClickListener(this);
			if (0 == i)
			{
				radiobutton[i].setChecked(true);
				((ImageView) findViewById(R.id.imageView)).setScaleType(scaleType);
			}
		}
	}

	public void onClick(View btn)
	{
		((ImageView) findViewById(R.id.imageView)).setScaleType(ImageView.ScaleType.values()[(Integer)btn.getTag() - 100]);
	}
}
