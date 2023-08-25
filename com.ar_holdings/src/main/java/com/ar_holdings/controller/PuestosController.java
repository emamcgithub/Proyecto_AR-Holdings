package com.ar_holdings.controller;

import com.ar_holdings.domain.Contacto;
import com.ar_holdings.domain.Puestos;
import com.ar_holdings.service.CategoriaService;
import com.ar_holdings.service.ContactoService;
import com.ar_holdings.service.FirebaseStorageService;
import com.ar_holdings.service.PuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/puestos")
public class PuestosController {

    @Autowired
    private PuestosService puestosService;

    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ContactoService contactoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        var puestos = puestosService.getPuestos(false);
        model.addAttribute("puestos", puestos);
        model.addAttribute("totalPuestos", puestos.size());

        return "/puestos/listado";
    }

    @GetMapping("/nuevo")
    public String puestosNuevo(Puestos puestos) {
        return "/puestos/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String puestosGuardar(Puestos puestos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            puestosService.save(puestos);
            puestos.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "puestos",
                            puestos.getIdPuesto()));
        }
        puestosService.save(puestos);
        return "redirect:/puestos/listado";
    }

    @GetMapping("/eliminar/{idPuesto}")
    public String puestosEliminar(Puestos puestos) {
        puestosService.delete(puestos);
        return "redirect:/puestos/listado";
    }

    @GetMapping("/modificar/{idPuesto}")
    public String puestosModificar(Puestos puestos, Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        puestos = puestosService.getPuestos(puestos);
        model.addAttribute("puestos", puestos);
        return "/puestos/modifica";
    }

    @GetMapping("/contacto")
    public String puestosContacto(Contacto contacto, Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        contacto = contactoService.getContacto(contacto);
        model.addAttribute("contacto", contacto);
        return "/contacto/listado";
    }
}
