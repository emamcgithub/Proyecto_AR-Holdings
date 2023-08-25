package com.ar_holdings.service.impl;

import com.ar_holdings.domain.Puestos;
import com.ar_holdings.service.PuestosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ar_holdings.dao.PuestosDao;

@Service
public class PuestosServiceImpl implements PuestosService {

    //La anotacion Autowired crea un único objeto sin hacer new.. y se mantiene
    @Autowired
    private PuestosDao puestosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Puestos> getPuestos(boolean activos) {
        var lista = puestosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Puestos getPuestos(Puestos puestos) {
        return puestosDao.findById(puestos.getIdPuesto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Puestos puestos) {
        puestosDao.save(puestos);
    }

    @Override
    @Transactional
    public void delete(Puestos puestos) {
        puestosDao.delete(puestos);
    }

}
