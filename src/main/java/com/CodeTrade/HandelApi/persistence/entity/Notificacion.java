package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table(name = "notificacion")
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Notificacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false, unique = true)
    private Integer idnotificacion;
    @Column(length = 50,nullable = false)
    private String mensaje;
    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;
    @Column(name = "fecha_notificacion",columnDefinition = "DATETIME")
    @CreatedDate
    private LocalDateTime fechaNotificacion;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",referencedColumnName = "idusuario" ,insertable = false, updatable = false)
    @JsonIgnore
    private Usuario usuarioNot;

}
