package com.ar_holdings.service.impl;

import com.ar_holdings.domain.Restaurante;
import com.ar_holdings.service.RestauranteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ar_holdings.dao.RestauranteDao;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    //La anotacion Autowired crea un único objeto sin hacer new.. y se mantiene
    @Autowired
    private RestauranteDao restauranteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Restaurante> getRestaurantes(boolean activos) {
        var lista = restauranteDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurante getRestaurante(Restaurante restaurante) {
        return restauranteDao.findById(restaurante.getIdRestaurante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Restaurante restaurante) {
        restauranteDao.save(restaurante);
    }

    @Override
    @Transactional
    public void delete(Restaurante restaurante) {
        restauranteDao.delete(restaurante);
    }
}
