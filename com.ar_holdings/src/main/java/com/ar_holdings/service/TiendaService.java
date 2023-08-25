package com.ar_holdings.service;

import com.ar_holdings.domain.Tienda;
import java.util.List;

public interface TiendaService {

//El sigueinte método retorna una lista con las tiendas 
//Que estan en la tabla tienda, todas o sólo las activas
    public List<Tienda> getTiendas(boolean activos);

    //Áca siguen los metodos para hacer un CRUD de la tabla tienda
    // Se obtiene un Tienda, a partir del id de un tienda
    public Tienda getTienda(Tienda tienda);

    // Se inserta un nuevo tienda si el id del tienda esta vacío
    // Se actualiza un tienda si el id del tienda NO esta vacío
    public void save(Tienda tienda);

    // Se elimina el tienda que tiene el id pasado por parámetro
    public void delete(Tienda tienda);
}
