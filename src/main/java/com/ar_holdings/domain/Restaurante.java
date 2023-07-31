package com.ar_holdings.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurantes")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Restaurante")
    private Long idRestaurante;
    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private String ubicacion;
    private int telefono;
    private String sitio_web;
    private String red_social;
    private boolean activo;

    public Restaurante() {
    }

    public Restaurante(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
