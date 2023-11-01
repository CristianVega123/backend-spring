package com.example.crud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bloc", schema = "public")
public class BlocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    @Column
    private String titulo;

    @Column
    private String asunto;

    @Column
    private String descripcion;

    @Column
    private String color;

}
