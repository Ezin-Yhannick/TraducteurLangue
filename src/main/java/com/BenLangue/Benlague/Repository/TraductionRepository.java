package com.BenLangue.Benlague.Repository;

import com.BenLangue.Benlague.Entity.Expressions;
import com.BenLangue.Benlague.Entity.Language;
import com.BenLangue.Benlague.Entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TraductionRepository extends JpaRepository<Translation, Long> {

    //Trouver une traduction à partir du texte et de la langue pour savoir l'expression correspondante
    Optional<Translation> findByLanguageAndTexteIgnoreCase(Language language, String texte);

    // Variante si tu préfères passer le code langue directement (pratique) :
    Optional<Translation> findByLanguage_CodeAndTexteIgnoreCase(String languageCode, String texte);

    // 2) Récupérer toutes les traductions d'une expression dans une langue donnée

    List<Translation> findByExpressionAndLanguage(Expressions expression, Language language);

    // Variante avec code langue
    List<Translation> findByExpressionAndLanguage_Code(Expressions expression, String languageCode);
}
