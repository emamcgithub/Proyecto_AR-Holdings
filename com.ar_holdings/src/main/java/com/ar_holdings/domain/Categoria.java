package com.ar_holdings.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "idCategoria")
    List<Restaurante> restaurante;

    @OneToMany
    @JoinColumn(name = "idCategoria")
    List<Tienda> tienda;

    @OneToMany
    @JoinColumn(name = "idCategoria")
    List<Puestos> puestos;

    @OneToMany
    @JoinColumn(name = "idCategoria")
    List<Contacto> contacto;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
