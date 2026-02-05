package com.minasdev.reprise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroeTest {

    @Test
    void heroeDebeTenerNombreYTituloGenerado() {
        // Arrange & Act
        Heroe heroe = new Heroe();

        // Imprimimos para ver qué generó la librería Faker (Efecto WOW para alumnos)
        System.out.println("Héroe generado: " + heroe.getNombreCompleto());
        System.out.println("Fuerza: " + heroe.getFuerza());

        // Assert
        assertNotNull(heroe.getNombreCompleto(), "El nombre no debería ser nulo");
        assertTrue(heroe.getNombreCompleto().isEmpty(), "El nombre no debería estar vacío"); // Es assertFalse no assertTrue
    }

    @Test
    void ataqueDebeSerDobleDeFuerza() {
        // Arrange
        Heroe heroe = new Heroe();
        int fuerzaBase = heroe.getFuerza();

        // Act
        int dano = heroe.atacar();

        // Assert
        assertEquals(fuerzaBase * 2, dano, "El daño debe ser el doble de la fuerza");
    }

    @Test
    void heroeMuertoNoDebeAtacar() {
        // Arrange
        Heroe heroe = new Heroe();
        heroe.recibirDano(200); // Matamos al héroe

        // Act
        int dano = heroe.atacar();

        // Assert
        assertEquals(0, dano, "Un héroe muerto no debe hacer daño");
        assertEquals(0, heroe.getVida(), "La vida no puede ser negativa");
    }
}