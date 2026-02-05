package com.minasdev.reprise;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚔️ --- GENERANDO BATALLA ÉPICA --- ⚔️");

        // 1. Instanciamos dos héroes (aquí es donde JavaFaker actúa por dentro)
        Heroe heroe1 = new Heroe();
        Heroe heroe2 = new Heroe();

        // 2. Presentación de combatientes
        presentarHeroe(1, heroe1);
        presentarHeroe(2, heroe2);

        System.out.println("\n¡QUE COMIENCE EL COMBATE!");
        System.out.println("-------------------------");

        // 3. Bucle de combate (mientras ambos sigan vivos)
        int turno = 1;
        while (heroe1.getVida() > 0 && heroe2.getVida() > 0) {
            System.out.println("\n--- TURNO " + turno + " ---");

            // Turno del Héroe 1
            realizarAtaque(heroe1, heroe2);
            if (heroe2.getVida() == 0) break; // Si el 2 muere, paramos

            // Pequeña pausa dramática de 1 segundo (try-catch o throws en main)
            Thread.sleep(1000);

            // Turno del Héroe 2
            realizarAtaque(heroe2, heroe1);

            turno++;
            Thread.sleep(1000);

            //CAMBIO TRIVIAL
        }

        // 4. Anunciar ganador
        System.out.println("\n🏆 ------------------------- 🏆");
        if (heroe1.getVida() > 0) {
            System.out.println("¡EL GANADOR ES: " + heroe1.getNombreCompleto().toUpperCase() + "!");
        } else {
            System.out.println("¡EL GANADOR ES: " + heroe2.getNombreCompleto().toUpperCase() + "!");
        }
    }

    // Métodos auxiliares para no ensuciar el main
    private static void presentarHeroe(int numero, Heroe h) {
        System.out.println("Jugador " + numero + ": " + h.getNombreCompleto());
        System.out.println("   💪 Fuerza: " + h.getFuerza() + " | ❤️ Vida: " + h.getVida());
    }

    private static void realizarAtaque(Heroe atacante, Heroe defensor) {
        int dano = atacante.atacar();
        defensor.recibirDano(dano);

        System.out.println("🗡️ " + atacante.getNombreCompleto() + " ataca con " + dano + " de daño.");
        System.out.println("🛡️ A " + defensor.getNombreCompleto() + " le quedan " + defensor.getVida() + " PV.");
    }
}