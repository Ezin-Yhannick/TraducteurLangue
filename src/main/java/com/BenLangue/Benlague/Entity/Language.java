package com.BenLangue.Benlague.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "Langagues")
public class Language {

    @Id @GeneratedValue
    private Long id;

    private String code;

    private String name;
}
