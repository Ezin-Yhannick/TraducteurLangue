package com.BenLangue.Benlague.Controller;

import com.BenLangue.Benlague.Entity.Expressions;
import com.BenLangue.Benlague.Entity.Translation;
import com.BenLangue.Benlague.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class GestionController {

    private final AdminService adminService;

    //....Controller pour les appels des services des Expressions
    @GetMapping("/expressions")
    public List<Expressions> getExpressions(){
        return adminService.getAllExpressions();
    }

    @PostMapping("/expressions")
    public Expressions createExpressions(@RequestBody Expressions expressions){
        return adminService.createExpressions(expressions);
    }

    @PutMapping("/expressions/{id}")
    public Expressions updateExpressions(@PathVariable Long id, @RequestBody Expressions expressions){
        return adminService.updateExpressions(id,expressions);
    }

    @DeleteMapping("/expressions/{id}")
    public void deleteExpressions(@PathVariable Long id){
        adminService.deleteExpressions(id);
    }

    //....Controller pour les appels des services des traductions

    @GetMapping("/traductions")
    public List<Translation> getAllTranslation(){
        return adminService.getAllTranslations();
    }

    @PostMapping("/traductions")
    public Translation createTranslation(@RequestBody Translation translation){
        return adminService.createTranslation(translation);
    }

    @PutMapping("/traductions/{id}")
    public Translation updateTranslation(@PathVariable Long id, @RequestBody Translation translation){
        return adminService.updateTranslation(id, translation);
    }

    @DeleteMapping("/traductions/{id}")
    public void deleteTranslation(@PathVariable Long id){
        adminService.deleteTranslation(id);
    }

    //Contreoller pour la gestion CRUD des fichiers audio

}
