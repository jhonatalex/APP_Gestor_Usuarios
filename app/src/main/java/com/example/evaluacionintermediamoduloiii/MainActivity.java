package com.example.evaluacionintermediamoduloiii;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
    private ListView listaclientes;
    private ArrayList contacto;
    private ArrayAdapter<String> adaptador;
    public Fragment fragmento1;
   FragmentTransaction Transac;
   private Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre=(EditText)findViewById(R.id.txt_nombre);
        telefono=(EditText)findViewById(R.id.txt_numero);
        listaclientes=(ListView)findViewById(R.id.lista);
        contacto= new ArrayList<String>();
        agregar=(Button)findViewById(R.id.button1);



        listaclientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                agregar.setEnabled(false);
                listaclientes.setEnabled(false);
                Toast.makeText(MainActivity.this, "maria", Toast.LENGTH_SHORT).show();
                //fragmento1= new ;
                Transac =getSupportFragmentManager().beginTransaction();
                Transac.add(R.id.contenedor1, new BlankFragment());
                Transac.commit();



            }
        });
    }

    public void agregar(View vista){
        contacto.add(nombre.getText().toString()+" "+telefono.getText().toString());
        adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacto);
        listaclientes.setAdapter(adaptador);




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
