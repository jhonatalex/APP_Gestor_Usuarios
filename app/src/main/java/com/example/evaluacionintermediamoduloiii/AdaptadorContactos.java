package com.example.evaluacionintermediamoduloiii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorContactos extends ArrayAdapter<Contacto> {

    Context context;
    List<Contacto> mList;
    int  recurso;

    public AdaptadorContactos(@NonNull Context context, int resource, List<Contacto> objects) {
        super(context, resource, objects);
        this.mList= objects;
        this.context= context;
        this.recurso=resource;
    }


    @Override
    public View getView(int i, View viewc, ViewGroup viewGroup) {
    View view=viewc;

        ImageView Imageimagen;
        TextView Textnombre;
        TextView Texttelefono;
        TextView Textedad;


        if (view ==null)
            view= LayoutInflater.from(context).inflate(R.layout.contacto,null);

        Contacto p1= mList.get(i);

        Imageimagen= view.findViewById(R.id.conctact);
        Textnombre=view.findViewById(R.id.nombres);
        Texttelefono =view.findViewById(R.id.edad2);
        Textedad =view.findViewById(R.id.fecha2);

        if (mList.get(i).getSexo()=='m'){
            Imageimagen.setImageResource(R.mipmap.men); }
        else
        {Imageimagen.setImageResource(R.mipmap.mujer); }

        Textnombre.setText(p1.nombre +" "+ p1.getApellido());
        Texttelefono.setText(String.valueOf(p1.getEdad()));
        Textedad.setText(p1.getFecha());


        return view;
    }


    }

