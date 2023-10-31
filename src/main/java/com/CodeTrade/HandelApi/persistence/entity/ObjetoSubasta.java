package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table (name = "objetosubastas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ObjetoSubasta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false, unique = true)
    private Integer idsubastas;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] imagen;
    @Column(length = 50,nullable = false)
    private String  titulo;
    @Column(length = 255,nullable = false)
    private String descripcion;
    @Column(length = 50)
    private String etiquetas;
    @Column(length = 25,nullable = false)
    private String categoria;
    @Column(length = 10,nullable = false)
    private String visibilidad;
    private Integer vistas=0;
    private Integer likes=0;
    @Column(nullable = false,columnDefinition = "Decimal(10,2)")
    private BigDecimal valor;
    @Column(nullable = false,columnDefinition = "Decimal(10,2)")
    private BigDecimal incremento;
    @Column(columnDefinition = "DATETIME")
    @CreatedDate
    private LocalDateTime fechadecreacion;
    @Column (name = "id_usuario",nullable = false)
    private Integer idUsuario;
    @Column (name = "id_usuarioganador")
    private Integer idGanador;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario",referencedColumnName = "idusuario" , insertable = false, updatable = false)
    @JsonIgnore
    private Usuario usuarioObSu;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuarioganador",referencedColumnName = "idusuario" , insertable = false, updatable = false)
    @JsonIgnore
    private Usuario usuarioObSuGanador;

}
