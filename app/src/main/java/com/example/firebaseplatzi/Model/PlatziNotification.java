package com.example.firebaseplatzi.Model;

public class PlatziNotification {

    private String titulo;
    private String description;
    private String id;
    private String descount;

    public PlatziNotification(String titulo, String description, String id, String descount) {
        this.titulo = titulo;
        this.description = description;
        this.id = id;
        this.descount = descount;
    }

    public PlatziNotification() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescount() {
        return descount;
    }

    public void setDescount(String descount) {
        this.descount = descount;
    }
}
