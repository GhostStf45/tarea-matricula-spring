package com.contoso.demo.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="t_alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;
    private String genero;
    private String carrera;

}
