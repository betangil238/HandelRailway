package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table(name = "contenido")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContenidoMensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer idcontenido;

    @Column(length = 255,nullable = false)
    private String mensaje;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column (name = "envia",nullable = false)
    private Integer idUsuario1;

    @Column (name = "chat",nullable = false)
    private Integer idChat;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="chat", referencedColumnName = "idmensajes",insertable = false, updatable = false)
    @JsonIgnore
    private Mensajes menCont;

}
