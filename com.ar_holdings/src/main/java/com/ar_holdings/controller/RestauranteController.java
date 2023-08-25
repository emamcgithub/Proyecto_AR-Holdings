package com.ar_holdings.controller;

import com.ar_holdings.domain.Restaurante;
import com.ar_holdings.service.CategoriaService;
import com.ar_holdings.service.RestauranteService;
import com.ar_holdings.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        var restaurantes = restauranteService.getRestaurantes(false);
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("totalRestaurantes", restaurantes.size());

        return "/restaurante/listado";
    }

    @GetMapping("/nuevo")
    public String restauranteNuevo(Restaurante restaurante) {
        return "/restaurante/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String restauranteGuardar(Restaurante restaurante,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            restauranteService.save(restaurante);
            restaurante.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "restaurante",
                            restaurante.getIdRestaurante()));
        }
        restauranteService.save(restaurante);
        return "redirect:/restaurante/listado";
    }

    @GetMapping("/eliminar/{idRestaurante}")
    public String restauranteEliminar(Restaurante restaurante) {
        restauranteService.delete(restaurante);
        return "redirect:/restaurante/listado";
    }

    @GetMapping("/modificar/{idRestaurante}")
    public String restauranteModificar(Restaurante restaurante, Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        restaurante = restauranteService.getRestaurante(restaurante);
        model.addAttribute("restaurante", restaurante);
        return "/restaurante/modifica";
    }
}
