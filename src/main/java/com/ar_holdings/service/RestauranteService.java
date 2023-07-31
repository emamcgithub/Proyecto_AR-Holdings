package com.ar_holdings.service;

import com.ar_holdings.domain.Restaurante;
import java.util.List;

public interface RestauranteService {

//El sigueinte método retorna una lista con las restaurantes 
//Que estan en la tabla restaurante, todas o sólo las activas
    public List<Restaurante> getRestaurantes(boolean activos);

    //Áca siguen los metodos para hacer un CRUD de la tabla restaurante
    // Se obtiene un Restaurante, a partir del id de un restaurante
    public Restaurante getRestaurante(Restaurante restaurante);

    // Se inserta un nuevo restaurante si el id del restaurante esta vacío
    // Se actualiza un restaurante si el id del restaurante NO esta vacío
    public void save(Restaurante restaurante);

    // Se elimina el restaurante que tiene el id pasado por parámetro
    public void delete(Restaurante restaurante);
}
