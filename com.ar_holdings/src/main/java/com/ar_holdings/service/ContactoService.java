package com.ar_holdings.service;

import com.ar_holdings.domain.Contacto;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public interface ContactoService {
//El sigueinte método retorna una lista con las contactos 
//Que estan en la tabla contacto, todas o sólo las activas
    public List<Contacto> getContacto(boolean activos);

    //Áca siguen los metodos para hacer un CRUD de la tabla contacto
    // Se obtiene un Contacto, a partir del id de un contacto
    public Contacto getContacto(Contacto contacto);
    
        // Se inserta un nuevo contacto si el id del contacto esta vacío
    // Se actualiza un contacto si el id del contacto NO esta vacío
    public void save(Contacto contacto);
    
        // Se elimina el contacto que tiene el id pasado por parámetro
    public void delete(Contacto contacto);
}
