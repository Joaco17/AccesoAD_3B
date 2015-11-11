package com.example.joaquin.accesoad_3b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private EditText cajaNombre;
    private EditText cajaDni;
    private EditText cajaFecha;
    private RadioGroup grupoSexo;
    private RadioButton radioHombre;
    private RadioButton radioMujer;
    private Button botonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaNombre = (EditText) findViewById(R.id.cajaNombre);
        cajaDni = (EditText) findViewById(R.id.cajaDni);
        cajaFecha = (EditText) findViewById(R.id.cajaFecha);
        grupoSexo = (RadioGroup) findViewById(R.id.grupoSexo);
        radioHombre = (RadioButton) findViewById(R.id.radioHombre);
        radioMujer = (RadioButton) findViewById(R.id.radioMujer);
        botonGuardar =(Button) findViewById(R.id.botonGuardar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void accionbotonGuardar(View v){

        Intent intent = new Intent(getApplicationContext(), Activity2.class);

        intent.putExtra("nombre", cajaNombre.getText().toString());
        intent.putExtra("dni", cajaDni.getText().toString());
        intent.putExtra("fecha", cajaFecha.getText().toString());

        String str=null;
        switch (grupoSexo.getCheckedRadioButtonId()) {
            case R.id.radioHombre:
                str="Hombre";
                break;
            case R.id.radioMujer:
                str="Mujer";
                break;
        }
        intent.putExtra("radioSexo", str);

        startActivityForResult(intent,1);

    }
}
