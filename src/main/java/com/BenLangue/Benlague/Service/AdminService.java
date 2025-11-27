package com.BenLangue.Benlague.Service;

import com.BenLangue.Benlague.Entity.Expressions;
import com.BenLangue.Benlague.Entity.Translation;
import com.BenLangue.Benlague.Repository.AudioFileRepository;
import com.BenLangue.Benlague.Repository.ExpressionsRepository;
import com.BenLangue.Benlague.Repository.TraductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Expression;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ExpressionsRepository  expressionsRepository;
    private final TraductionRepository traductionRepository;
    private final AudioFileRepository audioFileRepository;

    //CRUD des Expressions

    public List<Expressions> getAllExpressions(){
        return expressionsRepository.findAll();
    }

    public Expressions getExpressionsById(Long id){
        return expressionsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Expression non trouvée"));
    }

    public Expressions createExpressions(Expressions expressions){
        return  expressionsRepository.save(expressions);
    }

    public Expressions updateExpressions(Long id, Expressions expressions){
        Expressions existant = getExpressionsById(id);
        existant.setContexte(expressions.getContexte());
        existant.setPhrase(expressions.isPhrase());
        return expressionsRepository.save(existant);
    }

    public void deleteExpressions(Long id){
        expressionsRepository.deleteById(id);
    }

    //CRUD des Traductions

    public List<Translation> getAllTranslations(){
        return traductionRepository.findAll();
    }

    public Translation getTranslationById(Long id){
        return traductionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Traduction non trouvée"));
    }

    public Translation createTranslation(Translation translation){
        return traductionRepository.save(translation);
    }

    public Translation updateTranslation(Long id, Translation translation){
        Translation existing = getTranslationById(id);
        existing.setTexte(translation.getTexte());
        existing.setLanguage(translation.getLanguage());
        return traductionRepository.save(existing);
    }

    public void deleteTranslation(Long id) {
        traductionRepository.deleteById(id);
    }
}
