package com.ar_holdings.controller;

import com.ar_holdings.service.PuestosService;
import com.ar_holdings.service.RestauranteService;
import com.ar_holdings.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TiendasController {

    @Autowired
    private TiendaService tiendaService;
    
    @Autowired
    private RestauranteService restauranteService;
    
     @Autowired
    private PuestosService puestosService;


    @GetMapping("/")
    public String listado(Model model) {
        var tiendas = tiendaService.getTiendas(false);
        model.addAttribute("tiendas", tiendas);

        var restaurantes = restauranteService.getRestaurantes(false);
        model.addAttribute("restaurantes", restaurantes);
        
        var puestos = puestosService.getPuestos(false);
        model.addAttribute("puestos", puestos);

        return "index";
    }

}
