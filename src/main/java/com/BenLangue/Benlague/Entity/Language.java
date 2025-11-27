package com.BenLangue.Benlague.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Language {

    @Id @GeneratedValue
    private Long id;

    private String code;

    private String name;
}
