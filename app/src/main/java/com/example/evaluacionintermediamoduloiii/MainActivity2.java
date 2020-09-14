package com.example.evaluacionintermediamoduloiii;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    AdaptadorContactos Myadaptador;
    List<Contacto> mLista =new ArrayList<>();;


    public ListView ListaContenedor;
    public EditText nombre;
    public  EditText apellido1;
    public EditText edad1;
    public EditText fecha1;
    public ImageButton agregar;

    public RadioButton sexom;
    public RadioButton sexof;
    Integer pos;
    int index=0;
    private java.text.DateFormat DateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nombre=(EditText)findViewById(R.id.Name1);
        apellido1=(EditText)findViewById(R.id.ape);
        edad1=(EditText)findViewById(R.id.txt_edad);
        fecha1=(EditText)findViewById(R.id.txt_fecha);
        agregar=(ImageButton)findViewById(R.id.boton_agregar);


        ListaContenedor = (ListView)findViewById(R.id.lista);
        sexom= (RadioButton)findViewById(R.id.radioButton);
        sexof= (RadioButton)findViewById(R.id.radioButton2);



        Myadaptador  = new AdaptadorContactos(this,R.layout.contacto,mLista);
        ListaContenedor.setAdapter(Myadaptador);


        //PARA SELECCIONAR EL ITEN A MODIFICAR O ELIMNAR
        ListaContenedor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int ix, long l) {
                Contacto p=mLista.get(ix);
                Toast.makeText(MainActivity2.this, p.nombre, Toast.LENGTH_SHORT).show();


            }
        });

        // PARA QUE AL SELECIONAR SEA MAS LARGO A ITEN A MODIFICAR O ELIMNAR
        ListaContenedor.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                index=i;
                mostrardialog();
                return false;
            }
        });


        //CARGA LA VISTA DEL LISTVIEW PARA QUE SE VEA DiNAMICAMENTE
        View.OnClickListener IngresarDatos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //!EXECCION POR SI ESTAN VACIOS
                if(nombre.getText().toString().isEmpty() || apellido1.getText().toString().isEmpty()||
                        edad1.getText().toString().length()==0||fecha1.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity2.this, "DEBE INGRESAR TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();

                }else{



                    char valorSexo='m';
                    if (sexom.isChecked()== true){
                        valorSexo= 'f';
                            }else{
                                valorSexo= 'm';
                                }

                    mLista.add(new Contacto(nombre.getText().toString(),apellido1.getText().toString(),
                            Integer.parseInt(edad1.getText().toString()), fecha1.getText().toString(),
                            valorSexo,1));

                     Myadaptador.notifyDataSetChanged();
                     Snackbar.make(v, "Añadido Correctamente", Snackbar.LENGTH_LONG).show();


                    //LIMPIAR CAMPOS
                    nombre.setText(""); apellido1.setText("");  edad1.setText(""); fecha1.setText("");

                }

            }
        };

        agregar.setOnClickListener(IngresarDatos);
        ListaContenedor.setAdapter(Myadaptador);


        // FECHA

        fecha1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                DialogFragment Date = new DatePickerFragment();
                Date.show(getSupportFragmentManager(),"Date Picker");
                return false;
            }
        });







    }



    private void mostrardialog(){
        final int posicion=index;
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity2.this);
        builder.setTitle("Confirmacion");
        builder.setMessage("¿Desea Actualizar o Eliminar este Registro?")

                            .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int in) {
                                    Toast.makeText(getApplicationContext(),"Registro Eliminado...",Toast.LENGTH_LONG).show();
                                    mLista.remove(posicion);
                                    Myadaptador.notifyDataSetChanged();

                                }
                            })
                                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getApplicationContext(),"Cancelado..",Toast.LENGTH_LONG).show();
                                    }
                                    })

                                .setNeutralButton("Actualizar", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialogInterface, int i) {


                                       nombre.setText(mLista.get(posicion).getNombre());
                                       apellido1.setText(mLista.get(posicion).getApellido());
                                       edad1.setText(String.valueOf(mLista.get(posicion).getEdad()));
                                       fecha1.setText(mLista.get(posicion).getFecha());
                                       mLista.remove(posicion);
                                       Myadaptador.notifyDataSetChanged();
                                       Toast.makeText(MainActivity2.this, "Datos Cargados Para su Modificacion", Toast.LENGTH_SHORT).show();

                                    }
                                })


                                .show();


    }





    @Override
    public void onDateSet(DatePicker view, int ano, int mes, int dia) {

        //String FechaActual= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,ano);
        c.set(Calendar.MONTH,mes);
        c.set(Calendar.DAY_OF_MONTH,dia);

        fecha1.setText(dia+"/"+mes+"/"+ano);



        Calendar c1 = Calendar.getInstance();
        int ano_actual=c1.get(Calendar.YEAR);
        int mes_actual=c1.get(Calendar.MONTH);
        int dia_actual= c1.get(Calendar.DAY_OF_MONTH);



        //LLAMO AL METODO CALCULAR
        edad1.setText( String.valueOf(calcularEdad(ano_actual,mes_actual,dia_actual,ano,mes,dia)));
/*

*/



    }

    public int calcularEdad(int ano_actual, int mes_actual, int dia_actual, int ano_nacimiento, int mes_nacimiento, int dia_nacimiento) {
        int Edad, meses, Dias = 0;


        if(mes_nacimiento>mes_actual){
            if(dia_nacimiento>dia_actual){
                Edad=ano_actual-ano_nacimiento-1;
                meses=12-(mes_nacimiento-mes_actual)-1;
                Dias=(30-(dia_nacimiento-dia_actual))-1;
            }
            else if((30-(dia_nacimiento-dia_actual)-1>30)) {
                Edad = ano_actual - ano_nacimiento - 1;
                meses = 12 - (mes_nacimiento - mes_actual);
                Dias = (30 - (dia_nacimiento - dia_actual)) - 30;
            }else{
                Edad = ano_actual - ano_nacimiento - 1;
                meses = (12 - (mes_nacimiento - mes_actual))-1;
                Dias = (30 - (dia_nacimiento - dia_actual)) - 1;
            }

        }else if(dia_nacimiento>dia_actual) {
            Edad=ano_actual-ano_nacimiento;
            meses=(mes_actual-mes_nacimiento)-1;
            Dias = 30 - (dia_nacimiento - dia_actual);
        }else{
            Edad=ano_actual-ano_nacimiento;
            meses=mes_actual-mes_nacimiento;
            Dias = dia_actual-dia_nacimiento;


        }



        return Edad;

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
        if (id == R.id.action_settings2) {
            Intent entrar = new Intent(this, MainActivity.class);
            startActivity(entrar);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}






