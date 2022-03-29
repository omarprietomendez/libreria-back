package com.libreria.back.entity;

import javax.persistence.*;

@Entity
@Table(name = "PARTITURAS")
public class Partitura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String autor;
    private String obra;
    private String editorial;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
