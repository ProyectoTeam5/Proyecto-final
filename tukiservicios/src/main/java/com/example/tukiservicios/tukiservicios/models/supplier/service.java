package com.example.tukiservicios.tukiservicios.models.supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "service")
public class service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_service ;
    @Enumerated(EnumType.STRING)
    private ProfessionEnum profession;

}
