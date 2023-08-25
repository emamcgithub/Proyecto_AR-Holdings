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
    @Column(name = "id_restaurante")
    private Long idRestaurante;
    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private int telefono;
    private String ubicacion;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categoria categoria;

    public Restaurante() {
    }

    public Restaurante(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
