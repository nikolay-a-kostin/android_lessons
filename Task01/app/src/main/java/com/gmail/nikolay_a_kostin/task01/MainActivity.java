package com.gmail.nikolay_a_kostin.task01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Assert;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    ((Button)findViewById(R.id.button_radio)).setOnClickListener(this);
	    ((Button)findViewById(R.id.button_spin)).setOnClickListener(this);
    }

	@Override
	public void onClick(View btn)
	{
		if (false)
		{}
		else if (findViewById(R.id.button_radio) == btn)
		{
			Intent browserIntent = new Intent(this, RadioActivity.class);
			startActivity(browserIntent);
		}
		else if (findViewById(R.id.button_spin) == btn)
		{
			Intent browserIntent = new Intent(this, SpinActivity.class);
			startActivity(browserIntent);
		}
		else
		{
			Assert.assertTrue("Should never get here!", false);
		}
	}
}
