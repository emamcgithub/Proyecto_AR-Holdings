package com.ar_holdings.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "puestos")
public class Puestos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto")
    private Long idPuesto;
    private String nombre;
    private String turno;
    private String area;
    private double salario;
    private String requicitos;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categoria categoria;

    public Puestos() {
    }

    public Puestos(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
