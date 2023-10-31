package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table(name = "mensajes")
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Mensajes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false, unique = true)
    private Integer idmensajes;
    @Column(length = 255,nullable = false)
    private String mensaje;
    @Column(columnDefinition = "TIMESTAMP",nullable = false)
    @CreatedDate
    private LocalDateTime horaMensaje;
    @Column (name = "id_usuario1",nullable = false, unique = true)
    private Integer idUsuario1;
    @Column (name = "id_usuario2",nullable = false, unique = true)
    private Integer idUsuario2;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario1", referencedColumnName = "idusuario",insertable = false, updatable = false)
    @JsonIgnore
    private Usuario usuarioMens1;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario2", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @JsonIgnore
    private Usuario usuarioMens2;

}
