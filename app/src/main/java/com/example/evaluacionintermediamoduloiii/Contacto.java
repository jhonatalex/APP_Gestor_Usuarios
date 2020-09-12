package com.example.evaluacionintermediamoduloiii;

public class Contacto {
    public String nombre;
    private String apellido;
    private int edad;
    private String fecha;
    private char sexo;
    private int imagen;

    public Contacto(String nombre, String apellido, int edad, String fecha, char sexo, int imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fecha = fecha;
        this.sexo = sexo;
        this.imagen = imagen;

    }
    public Contacto(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;


    }

    public Contacto() {

    }

    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
