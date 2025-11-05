package edu.dam;

import gamecharacters.dao.CharacterDAO;
import gamecharacters.model.Character;
import gamecharacters.util.ConexionSQLite;

public class App {
    public static void main(String[] args) {
        try {
            // Inicializa la DB (como el "first run" del juego)
            ConexionSQLite.inicializar();

            CharacterDAO dao = new CharacterDAO();

            System.out.println("\n🎮 === CREANDO PERSONAJES === 🎮");
            dao.insertar(new Character("Aragorn", "Guerrero", 10, 150));
            dao.insertar(new Character("Gandalf", "Mago", 50, 80));
            dao.insertar(new Character("Legolas", "Arquero", 15, 120));

            System.out.println("\n📜 === LISTA DE PERSONAJES === 📜");
            dao.listar().forEach(System.out::println);

            System.out.println("\n⬆️ === SUBIENDO DE NIVEL === ⬆️");
            // Aragorn sube a nivel 11 y recupera vida
            Character aragorn = new Character();
            aragorn.setId(1);
            aragorn.setNombre("Aragorn");
            aragorn.setNivel(11);
            aragorn.setPuntosVida(170);
            dao.actualizar(aragorn);

            System.out.println("\n💀 === ELIMINANDO PERSONAJE === 💀");
            dao.eliminar(2); // Adiós Gandalf :(

            System.out.println("\n📜 === LISTA FINAL === 📜");
            dao.listar().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}