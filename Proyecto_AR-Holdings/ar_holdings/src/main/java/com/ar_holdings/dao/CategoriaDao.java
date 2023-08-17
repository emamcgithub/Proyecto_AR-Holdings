package com.ar_holdings.dao;

import com.ar_holdings.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{

    
}
