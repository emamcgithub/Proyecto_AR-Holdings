package com.ar_holdings.controller;

import com.ar_holdings.domain.Tienda;
import com.ar_holdings.service.TiendaService;
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
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var tienda = tiendaService.getTiendas(false);
        model.addAttribute("tienda", tienda);
        model.addAttribute("totalTienda", tienda.size());

        return "/tienda/listado";
    }

    @GetMapping("/nuevo")
    public String tiendaNuevo(Tienda tienda) {
        return "/tienda/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String tiendaGuardar(Tienda tienda,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            tiendaService.save(tienda);
            tienda.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "tienda",
                            tienda.getIdTienda()));
        }
        tiendaService.save(tienda);
        return "redirect:/tienda/listado";
    }

    @GetMapping("/eliminar/{idTienda}")
    public String tiendaEliminar(Tienda tienda) {
        tiendaService.delete(tienda);
        return "redirect:/tienda/listado";
    }

    @GetMapping("/modificar/{idTienda}")
    public String tiendaModificar(Tienda tienda, Model model) {
        tienda = tiendaService.getTienda(tienda);
        model.addAttribute("tienda", tienda);
        return "/tienda/modifica";
    }
}
