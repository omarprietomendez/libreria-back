package com.libreria.back.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PARTITURAS")
@ApiModel(description = "Detalles sobre las partituras")
public class Partitura {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @ApiModelProperty(notes = "Id único en el sistema")
    private int id;
    @ApiModelProperty(notes = "Autor o autores")
    private String autor;
    @ApiModelProperty(notes = "Nombre de la obra en la portada de la partitura")
    private String obra;
    @ApiModelProperty(notes = "Editorial")
    private String editorial;
    @ApiModelProperty(notes = "Notas adicionales como, por ejemplo, las obras adicionales no mencionadas en portada")
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
