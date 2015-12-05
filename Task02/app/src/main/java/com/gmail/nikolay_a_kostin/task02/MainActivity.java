package com.gmail.nikolay_a_kostin.task02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import junit.framework.Assert;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// адаптер
		ListView listView = (ListView) findViewById(R.id.listView);

		String[] planets = getResources().getStringArray(R.array.planets);
		Assert.assertTrue("Fix it!", 0 == planets.length % 3);

		MainAdapter adapter = new MainAdapter(this, planets);

		listView.setAdapter(adapter);
		listView.setSelection(0);
		listView.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{

	}
}
