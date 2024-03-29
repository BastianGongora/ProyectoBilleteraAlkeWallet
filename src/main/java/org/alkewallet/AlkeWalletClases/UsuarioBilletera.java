package org.alkewallet.AlkeWalletClases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa a un usuario con una billetera electrónica en el sistema Alke Wallet.
 * Extiende la clase abstracta Usuario e implementa funcionalidades específicas para la gestión de la billetera.
 */
public class UsuarioBilletera extends Usuario {
    private AlkeWallet alkeWallet; // Billetera electrónica asociada al usuario
    DecimalFormat df = new DecimalFormat("#.##"); // Formateador para mostrar solo dos decimales

    /**
     * Constructor de la clase UsuarioBilletera.
     *
     * @param id         Identificador único del usuario.
     * @param nombre     Nombre del usuario.
     * @param contraseña Contraseña del usuario.
     * @param rut        RUT (Rol Único Tributario) del usuario.
     * @param alkeWallet Billetera electrónica asociada al usuario.
     */
    public UsuarioBilletera(int id, String nombre, String contraseña, String rut, AlkeWalletImpl alkeWallet) {
        super(id, nombre, contraseña, rut);
        this.alkeWallet = alkeWallet;
    }

    /**
     * Método estático para iniciar sesión de un usuario.
     *
     * @param usuarios Lista de usuarios registrados en el sistema.
     * @param scanner  Objeto Scanner para entrada de datos.
     * @return El usuario autenticado si las credenciales son válidas, de lo contrario retorna null.
     */
    public static UsuarioBilletera iniciarSesion(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.print("Ingrese su rut de usuario: ");
        String nRut = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        String pass = scanner.next();

        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioBilletera) {
                UsuarioBilletera usuarioBilletera = (UsuarioBilletera) usuario;
                if (usuarioBilletera.rut.equals(nRut) && usuarioBilletera.contraseña.equals(pass)) {
                    return usuarioBilletera;
                }
            }
        }
        return null;
    }

    /**
     * Método para cerrar sesión del usuario.
     */
    @Override
    public void cerrarSesion() {
        System.out.println("Sesión cerrada.");
    }

    /**
     * Método para mostrar los datos del usuario y su saldo en diferentes monedas.
     */
    public void mostrarDatos() {

        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        System.out.println("¨       Alke Wallet        ¨");
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        System.out.println("Nombre de usuario: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Saldo: $" + alkeWallet.verSaldo());
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        double[] saldos = alkeWallet.convertirMoneda();
        System.out.println("Saldo en dólares: $" + df.format(saldos[0]));
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        System.out.println("Saldo en euros: €" + df.format(saldos[1]));
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    }

    /**
     * Método que muestra el menú de opciones para el usuario.
     *
     * @param scanner Objeto Scanner para entrada de datos.
     */
    public void menu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a ingresar: ");
                    double cantidadIngreso = scanner.nextDouble();
                    alkeWallet.realizarIngreso(cantidadIngreso);
                    mostrarDatos();
                    System.out.println("Ingreso exitoso. Nuevo saldo: $" + alkeWallet.verSaldo());

                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    alkeWallet.realizarRetiro(cantidadRetiro);
                    mostrarDatos();
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + alkeWallet.verSaldo());

                    break;
                case 3:
                    cerrarSesion();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }

    /**
     * Método estático para crear un nuevo usuario y agregarlo a la lista de usuarios.
     *
     * @param usuarios Lista de usuarios registrados en el sistema.
     * @param scanner  Objeto Scanner para entrada de datos.
     */
    public static void crearUsuario(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la contraseña del usuario: ");
        String contraseña = scanner.next();
        System.out.print("Ingrese el RUT del usuario: ");
        String rut = scanner.next();
        System.out.print("Ingrese el saldo inicial de la billetera del usuario: ");
        double saldoInicial = scanner.nextDouble();

        // Generar un ID para el nuevo usuario
        int nuevoId = usuarios.size() + 1;

        // Crear un nuevo usuario y agregarlo al arreglo de usuarios
        UsuarioBilletera nuevoUsuario = new UsuarioBilletera(nuevoId, nombre, contraseña, rut, new AlkeWalletImpl(saldoInicial));
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario creado exitosamente.");
    }

    /**
     * Método para listar usuarios por su RUT.
     *
     * @param usuarios Lista de usuarios registrados en el sistema.
     * @param rut      RUT para filtrar los usuarios a listar.
     */
    public void listarUsuariosPorRut(ArrayList<Usuario> usuarios, String rut) {
        System.out.println("Usuarios con RUT " + rut + ":");
        boolean encontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.rut.equals(rut)) {
                encontrado = true;
                System.out.println("ID: " + usuario.id);
                System.out.println("Nombre: " + usuario.nombre);
                System.out.println("Contraseña: " + usuario.contraseña);
                System.out.println("RUT: " + usuario.rut);
                System.out.println("---------------------------------");
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron usuarios con RUT " + rut);
        }
    }
}