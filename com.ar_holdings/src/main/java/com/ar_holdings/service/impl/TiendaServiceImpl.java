package com.ar_holdings.service.impl;

import com.ar_holdings.domain.Tienda;
import com.ar_holdings.service.TiendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ar_holdings.dao.TiendaDao;

@Service
public class TiendaServiceImpl implements TiendaService {

    //La anotacion Autowired crea un único objeto sin hacer new.. y se mantiene
    @Autowired
    private TiendaDao tiendaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tienda> getTiendas(boolean activos) {
        var lista = tiendaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Tienda getTienda(Tienda tienda) {
        return tiendaDao.findById(tienda.getIdTienda()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tienda tienda) {
        tiendaDao.save(tienda);
    }

    @Override
    @Transactional
    public void delete(Tienda tienda) {
        tiendaDao.delete(tienda);
    }
}
