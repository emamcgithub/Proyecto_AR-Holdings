package com.ar_holdings.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long idContacto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono;
    private String correo;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categoria categoria;

    public Contacto() {
    }

    public Contacto(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

}
