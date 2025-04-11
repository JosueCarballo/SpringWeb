package com.example.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/inicio")
    public String mostrarFormularioLogin(@RequestParam(required = false) String usuario,
                                         @RequestParam(required = false) String contrasena,
                                         @RequestParam(required = false) String error,
                                         Model model) {
        if (usuario != null && contrasena != null) {
            if ("admin".equals(usuario) && "1234".equals(contrasena)) {
                model.addAttribute("nombreUsuario", usuario);
                return "home";
            } else {
                model.addAttribute("mensajeError", "Inicio de sesión no exitoso. Intenta nuevamente.");
            }
        } else if ("true".equals(error)) {
            model.addAttribute("mensajeError", "Inicio de sesión no exitoso. Intenta nuevamente.");
        }
        return "login";
    }

    @PostMapping("/inicio")
    public String procesarLogin(@RequestParam String usuario,
                                @RequestParam String contrasena,
                                Model model) {
        if ("admin".equals(usuario) && "1234".equals(contrasena)) {
            model.addAttribute("nombreUsuario", usuario);
            return "home";
        } else {
            return "redirect:/inicio?error=true";
        }
    }
}
