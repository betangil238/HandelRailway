package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "usuario")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario",nullable = false, unique = true)
    private Integer idUsuario;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(length = 50)
    private String name2;
    @Column(nullable = false, length = 100)
    private String email;
    private Integer reset=0;
    @Column(unique = true, length = 50)
    private String usuario;
    @Column(unique = true, length = 50)
    private String usuario1;
    @Column(columnDefinition = "Decimal(10,2)")
    private BigDecimal saldo;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] imagen;
    @Column(length = 50)
    private String contrasena;
    @Column(columnDefinition = "FLOAT")
    private Float puntuacion;
    @Column(name = "plan_premium")
    private String planPremium;
    private Integer pujas=10;
    private Integer trueques=3;
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;


    @OneToMany (mappedBy = "usuarioMens1",fetch =  FetchType.EAGER)
    private List<Mensajes> mensajes1;

    @OneToMany (mappedBy = "usuarioMens2",fetch =  FetchType.EAGER)
    private List<Mensajes> mensajes2;

    @OneToMany (mappedBy = "usuarioNot",fetch =  FetchType.EAGER)
    private List<Notificacion> notificaciones;

    @OneToMany (mappedBy = "usuarioObSu",fetch =  FetchType.EAGER)
    private List<ObjetoSubasta> objetosDeSubasta;

    @OneToMany (mappedBy = "usuarioObSuGanador", fetch =  FetchType.EAGER)
    private List<ObjetoSubasta> objetosDeSubastaGanador;

    @OneToMany (mappedBy = "usuarioObTr", fetch =  FetchType.EAGER)
    @JsonIgnore
    private List<ObjetoTrueque> objetosDeTrueque;
}
