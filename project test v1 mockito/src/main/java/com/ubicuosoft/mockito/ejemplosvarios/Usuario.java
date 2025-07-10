package com.ubicuosoft.mockito.ejemplosvarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(min=3, max=20, message = "El nombre del usuario debe tener entre 3 y 20 caracteres.")
    private String nombre;
    @Email(message = "El formato del correo no es válido.")
    private String email;
}
