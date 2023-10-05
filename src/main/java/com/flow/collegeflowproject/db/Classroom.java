package com.flow.collegeflowproject.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = " tb_turma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = " nm_turma")
    private String nmClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_periodo")
    private Period period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno")
    private Shift shift;

    @Column(name = "qtd_vagas")
    private Long vacancies;

    @Column(name = "qtd_aluno")
    private Long qtStudent;


    @Enumerated(EnumType.ORDINAL)
    private StatusRecord status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao_predio")
    private Building building;


    public Classroom(Long vacancies, Long qtStudent) {
        this.vacancies = vacancies;
        this.qtStudent = qtStudent;
    }


}
