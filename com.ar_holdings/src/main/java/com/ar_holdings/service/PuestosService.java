package com.ar_holdings.service;

import com.ar_holdings.domain.Puestos;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public interface PuestosService {

//El sigueinte método retorna una lista con las puestoss 
//Que estan en la tabla puestos, todas o sólo las activas
    public List<Puestos> getPuestos(boolean activos);

    //Áca siguen los metodos para hacer un CRUD de la tabla puestos
    // Se obtiene un Puestos, a partir del id de un puestos
    public Puestos getPuestos(Puestos puestos);

    // Se inserta un nuevo puestos si el id del puestos esta vacío
    // Se actualiza un puestos si el id del puestos NO esta vacío
    public void save(Puestos puestos);

    // Se elimina el puestos que tiene el id pasado por parámetro
    public void delete(Puestos puestos);
}
