package com.ar_holdings.controller;

import com.ar_holdings.domain.Contacto;
import com.ar_holdings.service.CategoriaService;
import com.ar_holdings.service.ContactoService;
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
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        var contacto = contactoService.getContacto(false);
        model.addAttribute("contacto", contacto);
        model.addAttribute("totalContacto", contacto.size());

        return "/contacto/listado";
    }

    @GetMapping("/nuevo")
    public String contactoNuevo(Contacto contacto) {
        return "/contacto/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String contactoGuardar(Contacto contacto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            contactoService.save(contacto);
            contacto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "contacto",
                            contacto.getIdContacto()));
        }
        contactoService.save(contacto);
        return "redirect:/contacto/listado";
    }

    @GetMapping("/eliminar/{idContacto}")
    public String contactoEliminar(Contacto contacto) {
        contactoService.delete(contacto);
        return "redirect:/contacto/listado";
    }

    @GetMapping("/modificar/{idContacto}")
    public String contactoModificar(Contacto contacto, Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        contacto = contactoService.getContacto(contacto);
        model.addAttribute("contacto", contacto);
        return "/contacto/modifica";
    }
}
