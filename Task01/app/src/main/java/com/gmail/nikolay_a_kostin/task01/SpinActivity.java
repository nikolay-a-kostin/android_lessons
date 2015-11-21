package com.gmail.nikolay_a_kostin.task01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import junit.framework.Assert;

public class SpinActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spin);

		Spinner spinner = (Spinner) findViewById(R.id.activity_spin_spinner);
		spinner.setAdapter(new SpinAdapter(this));
		spinner.setOnItemSelectedListener(this);
		spinner.setSelection(0);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		((ImageView) findViewById(R.id.activity_spin_image)).setScaleType(ImageView.ScaleType.values()[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		
	}
}
