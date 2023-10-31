package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "trueque")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trueque {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false, unique = true)
    private Integer idtrueques;
    @Column(name ="id_objetotrueque1")
    private Integer idObjetoTrueque1;
    @Column(name ="id_objeto2trueque")
    private Integer idObjetoTrueque2;
    @Column(length = 50)
    private String estado="pendiente";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_objetotrueque1", referencedColumnName = "idtrueques", insertable = false, updatable = false)
    @JsonIgnore
    private ObjetoTrueque objetoTrueque1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_objeto2trueque", referencedColumnName = "idtrueques", insertable = false, updatable = false)
    @JsonIgnore
    private ObjetoTrueque objetoTrueque2;

}
