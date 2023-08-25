package com.ar_holdings.service.impl;

import com.ar_holdings.service.ContactoService;
import org.springframework.stereotype.Service;
import com.ar_holdings.dao.ContactoDao;
import com.ar_holdings.domain.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {

    //La anotacion Autowired crea un único objeto sin hacer new.. y se mantiene
    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getContacto(boolean activos) {
        var lista = contactoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    @Transactional
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }

}
