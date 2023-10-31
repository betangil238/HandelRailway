package com.CodeTrade.HandelApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "objetotrueque")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ObjetoTrueque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtrueques", nullable = false, unique = true)
    private Integer idTrueques;
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
    @Column (name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Column(columnDefinition = "DATETIME")
    @CreatedDate
    private LocalDateTime fechadecreacion;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", referencedColumnName = "idusuario" , insertable = false, updatable = false)
    @JsonIgnore
    private Usuario usuarioObTr;

    @OneToMany (mappedBy = "objetoTrueque1",fetch =  FetchType.EAGER)
    private List<Trueque> trueques1;

    @OneToMany (mappedBy = "objetoTrueque2",fetch =  FetchType.EAGER)
    private List<Trueque> trueques2;

}
