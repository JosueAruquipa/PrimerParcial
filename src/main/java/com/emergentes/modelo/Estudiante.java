package com.emergentes.modelo;
/**
 *
 * @author Josué
 */
public class Estudiante {
    private int id;
    private String nombre;
    private int p1;
    private int p2;
    private int ef;
    
    public Estudiante(){
        id=0;
        nombre="";
        p1=0;
        p2=0;
        ef=0;
    }
    public Estudiante(int id, String nombre, int p1, int p2, int ef) {
        this.id = id;
        this.nombre = nombre;
        this.p1 = p1;
        this.p2 = p2;
        this.ef = ef;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getP1() {
        return p1;
    }
    public int getP2() {
        return p2;
    }
    public int getEf() {
        return ef;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setP1(int p1) {
        this.p1 = p1;
    }
    public void setP2(int p2) {
        this.p2 = p2;
    }
    public void setEf(int ef) {
        this.ef = ef;
    }   
}
