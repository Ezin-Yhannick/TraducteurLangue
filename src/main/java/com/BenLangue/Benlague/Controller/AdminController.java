package com.BenLangue.Benlague.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @GetMapping("/admin/login")
    public String adminLogin(){
        return "admin/login";
    }

    @GetMapping("/admin/tableau_de_board")
    public String adminDashboard(){
        return "admin/tableau_de_board";
    }

    @GetMapping("/admin/gestion_utilisateurs")
    public String manage_users(){return "admin/gestion_utilisateurs";}

    @GetMapping("/admin/manage_expressions")
    public String manageExpressions(){
        return "admin/manage_expressions";
    }

    @GetMapping("/admin/manage_traductions")
    public String manageTraductions(){
        return "admin/manage_traductions";
    }

    @GetMapping("/admin/manage_languages")
    public String manageLanguages(){
        return "admin/manage_languages";
    }

    @GetMapping("/admin/gestion_paramètres")
    public String settings(){return "admin/gestion_paramètres";}
}
