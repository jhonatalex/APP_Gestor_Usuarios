package com.example.evaluacionintermediamoduloiii;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText nombre;
    private EditText telefono;
    private ListView ListViewclientes;
    private ArrayList Listacontactos;
    private ArrayAdapter<String> adaptador;
    private Button agregar;
    private Button actualizar;
    Integer posicion;
    int index=0;

    Integer j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText) findViewById(R.id.txt_nombre);
        telefono = (EditText) findViewById(R.id.txt_numero);
        ListViewclientes = (ListView) findViewById(R.id.lista);
        agregar = (Button) findViewById(R.id.bt_agregar);
        actualizar = (Button) findViewById(R.id.bt_actualizar);

        Listacontactos = new ArrayList<String>();

        adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,Listacontactos);
        ListViewclientes.setAdapter(adaptador);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nombre.getText().toString().isEmpty() || telefono.getText().toString().isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Por favor Todos Los campos", Toast.LENGTH_SHORT).show();
                    nombre.requestFocus();

                } else {

                    Listacontactos.add("Nombre: "+ nombre.getText().toString()+" Telf: "+telefono.getText().toString());
                    nombre.setText("");
                    telefono.setText("");
                    adaptador.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Contacto Añadido", Toast.LENGTH_LONG).show();
                }

            }
        });



        ListViewclientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                Toast.makeText(MainActivity.this,adapterView.getItemAtPosition(i).toString() , Toast.LENGTH_SHORT).show();
                posicion =i;
            }
        });



        actualizar .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String varnombre = nombre.getText().toString();
                String vartelefono = telefono.getText().toString();

                if (posicion == null || nombre.equals("") || Listacontactos.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Seleccione Para Actualizar", Toast.LENGTH_SHORT).show();
                } else if (varnombre.isEmpty()) {
                        Toast.makeText(MainActivity.this,"Rellene los campos" + Listacontactos.get(posicion), Toast.LENGTH_SHORT).show();

                        } else if(vartelefono.isEmpty()){
                        Toast.makeText(MainActivity.this,"Rellene los campos" + Listacontactos.get(posicion).toString() , Toast.LENGTH_SHORT).show();

                            }else{
                                 Listacontactos.set(posicion, "Nombre: "+varnombre +"  Telf.: "+vartelefono );
                                 adaptador.notifyDataSetChanged();
                                 }

            }
        });


        ListViewclientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                index=i;;
                MostarDialogopersonalizado();

                return false;

            }

        });




    }

    private void MostarDialogopersonalizado() {
        final int  j=index;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater pop= getLayoutInflater();
        View view=pop.inflate(R.layout.fragment_blank,null);
        builder.setView(view);


        final AlertDialog alerta=builder.create();

        alerta.show();


        Button cancel=view.findViewById(R.id.canx);
        Button confirm=view.findViewById(R.id.conx);


        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View vista) {

                Toast.makeText(MainActivity.this, "DATOS BORRADOS !!!", Toast.LENGTH_SHORT).show();
                Listacontactos.remove(j);
                adaptador.notifyDataSetChanged();
                alerta.dismiss();

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta.dismiss();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent entrar = new Intent(this, MainActivity2.class);
            startActivity(entrar);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
