package com.umg.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dpi", unique = true)
    private String dpi;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "genero_persona_id")
    private Long generoPersonaId;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "idioma_id")
    private Long idiomaId;

    @Column(name = "grupo_etnico_id")
    private Long grupoEtnicoId;

    @Column(name = "nivel_escolar_id")
    private Long nivelEscolarId;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "departamento_id")
    private Long departamentoId;

    @Column(name = "municipio_id")
    private Long municipioId;

    @Column(name = "estado_cl_id")
    private Long estadoClId;

}
