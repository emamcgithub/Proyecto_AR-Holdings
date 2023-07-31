package com.ar_holdings.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "tiendas")
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Tienda")
    private Long idTienda;
    private String nombre;
    private String rutaImagen;
    private String ubicacion;
    private int telefono;
    private String sitio_web;
    private String red_social;
    private String descripcion;
    private boolean activo;

    public Tienda() {
    }

    public Tienda(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
