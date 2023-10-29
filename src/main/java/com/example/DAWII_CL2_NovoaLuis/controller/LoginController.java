package com.example.DAWII_CL2_NovoaLuis.controller;

import com.example.DAWII_CL2_NovoaLuis.model.Usuario;
import com.example.DAWII_CL2_NovoaLuis.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {

    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(){
        return "frmLogin";
    }

    @PostMapping("/login-success")
    public String loginSuccess(HttpServletRequest request) {
        // Get the authenticated user's details
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        HttpSession session = request.getSession();
        session.setAttribute("username", userDetails.getUsername());
        return "home";
    }


    @GetMapping("/registrar")
    public String registrar(){
        return "frmRegistro";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.saveUser(usuario);
        return "frmLogin";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
