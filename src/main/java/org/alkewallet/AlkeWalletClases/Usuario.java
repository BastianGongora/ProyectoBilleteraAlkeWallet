package org.alkewallet.AlkeWalletClases;

/**
 * Clase abstracta que representa un usuario.
 * Define atributos comunes para los diferentes tipos de usuarios y métodos abstractos para iniciar y cerrar sesión.
 */
public abstract class Usuario {
    protected int id; // Identificador único del usuario
    protected String nombre; // Nombre del usuario
    protected String contraseña; // Contraseña del usuario
    protected String rut; // RUT (Rol Único Tributario) del usuario

    /**
     * Constructor de la clase Usuario.
     *
     * @param id         Identificador único del usuario.
     * @param nombre     Nombre del usuario.
     * @param contraseña Contraseña del usuario.
     * @param rut        RUT (Rol Único Tributario) del usuario.
     */
    public Usuario(int id, String nombre, String contraseña, String rut) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rut = rut;
    }

    /**
     * Método abstracto para cerrar sesión del usuario.
     * Este método debe ser implementado por las subclases para proporcionar el comportamiento específico de cierre de sesión.
     */

    public abstract void cerrarSesion();
}