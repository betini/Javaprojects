package com.example.calculadoraxml;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


	
	//DECLARAR OBJETOS
	TextView tv;
	EditText et1;
	EditText et2;
	TextView tv2;
	
	double dato1;
	double dato2;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) this.findViewById(R.id.aviso);
		tv2 = (TextView) this.findViewById(R.id.resultado);
		et1 = (EditText) this.findViewById(R.id.dato1);
		et2 = (EditText) this.findViewById(R.id.dato2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void suma (View v)
	{
		this.dato1 = Double.parseDouble(this.et1.getText().toString());
		this.dato2 = Double.parseDouble(this.et2.getText().toString());   
		tv.setText("se sumo correctamente");
		tv2.setText(Double.toString((this.dato1 + this.dato2)));
	}

	public void resta (View v)
	{
		this.dato1 = Double.parseDouble(this.et1.getText().toString());
		this.dato2 = Double.parseDouble(this.et2.getText().toString());   
		tv.setText("se restar correctamente");
		tv2.setText(Double.toString((this.dato1 - this.dato2)));
	}
	
	public void multiplica (View v)
	{
		this.dato1 = Double.parseDouble(this.et1.getText().toString());
		this.dato2 = Double.parseDouble(this.et2.getText().toString());   
		tv.setText("se multiplica correctamente");
		tv2.setText(Double.toString((this.dato1 * this.dato2)));
	}
	
	public void divide (View v)
	{
		this.dato1 = Double.parseDouble(this.et1.getText().toString());
		this.dato2 = Double.parseDouble(this.et2.getText().toString());   
		tv.setText("se divide correctamente");
		tv2.setText(Double.toString((this.dato1 / this.dato2)));
	}
	public void enter (View v)
	{
		this.dato1 = Double.parseDouble(this.et1.getText().toString());
		this.dato2 = Double.parseDouble(this.et2.getText().toString());   
		tv.setText("se divide correctamente");
		tv2.setText(Double.toString((this.dato1 / this.dato2)));
	}

}