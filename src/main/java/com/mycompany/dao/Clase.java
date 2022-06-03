/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author ERLIN
 */
public class Clase {
    
    public Clase(){
        
    }
    
    public Clase(int id, 
            String nombre, 
            String estado,
            String email,
            String password,
            String avatar,
            String fchIngreso){
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.fchIngreso = fchIngreso;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getFchIngreso() {
        return fchIngreso;
    }

    public void setFchIngreso(String fchIngreso) {
        this.fchIngreso = fchIngreso;
    }
    public String printString(){
        return String.valueOf(id) + '\t' 
                + nombre + '\t' + estado + '\t' 
                + email + '\t' + password + '\t' 
                + avatar + '\t' + fchIngreso;
    }
    
    private int id;
    private String nombre;
    private String estado;
    private String email;
    private String password;
    private String avatar;
    private String fchIngreso;
    
   
}
