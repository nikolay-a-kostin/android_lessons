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

		// адаптер
		Spinner spinner = (Spinner) findViewById(R.id.spinner);

		String[] scale_str = getResources().getStringArray(R.array.scale);
		Assert.assertTrue("Fix it!", scale_str.length == ImageView.ScaleType.values().length);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, scale_str);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);
		spinner.setPrompt("Title");
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// показываем позиция нажатого элемента
		((ImageView) findViewById(R.id.imageView)).setScaleType(ImageView.ScaleType.values()[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		
	}
}
