package com.example.joaquin.accesoad_3b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends Activity {

    private TextView textoNombre;
    private TextView textoDni;
    private TextView textoFecha;
    private TextView textoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textoNombre = (TextView) findViewById(R.id.textoNombre);
        textoDni = (TextView) findViewById(R.id.textoDni);
        textoFecha = (TextView) findViewById(R.id.textoFecha);
        textoSexo = (TextView) findViewById(R.id.textoSexo);

        recojerDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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

    public void recojerDatos(){
        Bundle bundle = getIntent().getExtras();

        String nombre = bundle.getString("nombre");
        String dni = bundle.getString("dni");
        String fecha = bundle.getString("fecha");
        String sexo = bundle.getString("radioSexo");

        textoNombre.setText("Nombre: "+nombre);
        textoDni.setText("Dni: "+dni);
        textoFecha.setText("Fecha: "+fecha);

        textoSexo.setText("Sexo: "+sexo);
    }

    public void accionbotonVolver(View v){

       Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
