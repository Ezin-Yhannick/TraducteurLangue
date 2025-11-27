package com.BenLangue.Benlague.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AudioFile {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Translation translation;

    private String filepath;

    /*
    Cette table va contenr les fichiers audios d'une belle voix qui va servir de traduction dans nos langues locales     */
}

