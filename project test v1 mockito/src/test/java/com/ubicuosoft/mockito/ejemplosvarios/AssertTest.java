package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AssertTest {
    @Test
    void deberiaAfirmarValoresSimples() {
        //---Given
        int edad = 25;
        String nombre = "Victor";
        //---When

        //---Then
        assertThat(edad).isEqualTo(25);
        assertThat(edad).isGreaterThan(18).isLessThan(30);
        assertThat(nombre).isNotNull().startsWith("V").endsWith("r");
        assertThat(nombre).isEqualToIgnoringCase("victor");
    }

    @Test
    void deberiaAfirmarValoresBooleanos() {
        boolean activo = true;
        assertThat(activo).isTrue();
        assertThat(!activo).isFalse();
    }

    @Test
    void deberiaAfirmarListasColecciones() {
        List<String> nombres = List.of("Ana", "Luis", "Carlos");
        assertThat(nombres).hasSize(3);
        assertThat(nombres).contains("Ana", "Luis");
        assertThat(nombres).doesNotContain("Pedro");
        assertThat(nombres).containsExactly("Ana", "Luis", "Carlos");
        assertThat(nombres).startsWith("Ana").endsWith("Carlos");
    }

    @Test
    void deberiaAfirmarMapas() {
        Map<String, Integer> edades = Map.of("Ana", 20, "Luis", 30);
        assertThat(edades).containsKey("Ana");
        assertThat(edades).containsEntry("Luis", 30);
        assertThat(edades).doesNotContainKey("Pedro");
    }

    @Test
    void deberiaAfirmarOptional() {
        Optional<String> nombre = Optional.of("Victor");
        assertThat(nombre).isPresent();
        assertThat(nombre).hasValue("Victor");
        assertThat(nombre.get()).startsWith("Vic");
    }

    @Test
    void deberiaAfirmarObjetosPersonalizados() {
        Usuario usuario = new Usuario(1L, "Victor", "victor@gmail.com",15);
        assertThat(usuario.getNombre()).isEqualTo("Victor");
        assertThat(usuario.getEmail()).contains("@");
    }

    @Test
    void deberiaAfirmarExcepciones() {
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("ID invalido");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalido");
    }

    @Test
    void deberiaAfirmarString() {
        String saludo = "Hola mundo";
        assertThat(saludo).startsWith("Hola");
        assertThat(saludo).endsWith("mundo");
        assertThat(saludo).contains("la mundo");
        assertThat(saludo).isEqualToIgnoringCase("hola mundo");

        assertThat(saludo).startsWith("Hola").endsWith("mundo").contains("la mundo").isEqualToIgnoringCase("hola mundo");
    }

    @Test
    void deberiaAfirmarFechasTiempos() {
        LocalDate hoy = LocalDate.now();
        LocalDate ayer = hoy.minusDays(1);
        assertThat(hoy).isAfter(ayer);
        assertThat(ayer).isBefore(hoy);
    }

    @Test
    void deberiaAfirmarArrays() {
        String[] colores = {"Rojo", "Amarillo", "Verde"};
        assertThat(colores).contains("Verde");
        assertThat(colores).startsWith("Rojo");
        assertThat(colores).hasSize(3);
    }

    @Test
    void deberiaAfirmarNulls() {
        String nombre = null;
        assertThat(nombre).isNull();

        nombre = "Victor";
        assertThat(nombre).isNotNull();
    }

    @Test
    void deberiaAfirmarClasesTipos() {
        Object valor = "Hola";
        assertThat(valor).isInstanceOf(String.class);
        //assertThat(valor.getClass()).hasSimpleName("String"); //not working
    }

    @Test
    void deberiaAfirmarLambdas() {
        List<Integer> numeros = List.of(2, 4, 6, 8);
        assertThat(numeros).allMatch(n -> n % 2 == 0); //coincide todos pares
        assertThat(numeros).noneMatch(n -> n < 0); //ninguno coincide negativo
    }
}
