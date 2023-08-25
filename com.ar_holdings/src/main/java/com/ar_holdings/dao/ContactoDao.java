package com.ar_holdings.dao;

import com.ar_holdings.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository<Contacto, Long> {

}
