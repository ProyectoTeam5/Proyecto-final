package com.tukiservice.models.supplier;

import com.tukiservice.models.Erole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long Idservice;

    @Enumerated(EnumType.STRING)
    private ProfessionEnum profession;

    @Enumerated(EnumType.STRING)
    private Erole rol;

}
