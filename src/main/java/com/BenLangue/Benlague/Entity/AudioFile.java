package com.BenLangue.Benlague.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "FichierAudio")
public class AudioFile {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Translation translation;

    private String filepath;

    /*
    Cette table va contenr les fichiers audios d'une belle voix qui va servir de traduction dans nos langues locales     */
}

