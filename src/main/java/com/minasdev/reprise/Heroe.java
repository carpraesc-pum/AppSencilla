package com.minasdev.reprise;

import com.github.javafaker.Faker;

public class Heroe {
    private String nombre;
    private String titulo;
    private int fuerza;
    private int vida;

    // Constructor que usa la librería externa para generar datos
    /* Constructor por defecto que genera un héroe con nombre, título, fuerza y vida iniciales.
       Utiliza la librería JavaFaker para crear nombres y títulos aleatorios.

       @author Equipo MinasDev
       @version 1.0
    */
    public Heroe() {
        Faker faker = new Faker(); // Magia de la librería externa

        // Generamos un nombre de personaje y título de Dune
        this.nombre = faker.dune().character();
        this.titulo = faker.dune().title();

        // La fuerza es aleatoria entre 1 y 100
        this.fuerza = faker.number().numberBetween(1, 100);
        this.vida = 100;
    }

    /* Ataca al oponente, calculando el daño basado en la fuerza del héroe.
       Si el héroe está muerto (vida <= 0), no puede atacar y devuelve 0 de daño.

       @return int El daño infligido al oponente.
    */
    // Método de lógica del juego
    public int atacar() {
        if (vida <= 0) {
            return 0; // Si está muerto, no hace daño
        }
        // El daño es la fuerza más un bono
        return fuerza * 2;
    }

    /* Recibe daño y reduce la vida del héroe.
       Si la vida cae por debajo de 0, se ajusta a 0.

       @param dano int La cantidad de daño recibido.
    */
    public void recibirDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }

    // Getters
    public String getNombreCompleto() {
        return nombre + " de la casa " + titulo;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }
}