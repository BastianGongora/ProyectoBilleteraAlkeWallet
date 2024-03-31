package org.alkewallet;

import org.alkewallet.AlkeWalletClases.AlkeWalletImpl;
import org.alkewallet.AlkeWalletClases.Usuario;
import org.alkewallet.AlkeWalletClases.UsuarioBilletera;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Clase principal que contiene el punto de entrada del programa.
 * Permite interactuar con el usuario a través de un menú.
 *
 *  * @author Bastián Luis Antonio Góngora Barrera
 *  * @version 0.1
 */

public class Main {
    public static void main(String[] args) {
        // Arreglo para almacenar usuarios
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioBilletera usuario = new UsuarioBilletera(0, "nombreUsuario", "contraseña", "rut", new AlkeWalletImpl(0.0));

        // Crear usuarios predefinidos para pruebas
        UsuarioBilletera usuario1 = new UsuarioBilletera(1, "Juan Perez", "123", "123456789", new AlkeWalletImpl(100.0));
        UsuarioBilletera usuario2 = new UsuarioBilletera(2, "Alejandro Mora", "123", "987654321", new AlkeWalletImpl(200.0));

        // Agregar usuarios al arreglo
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        // Interacción con el usuario a través del menú
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Inicio Sesión");
            System.out.println("2. Crear Cuenta Usuario");
            System.out.println("3. Salir");
            System.out.println("------------------------------");
            System.out.println("Metodo para buscar si existe usuarios es para pruebas");
            System.out.println("4. Buscar Usuario");
            System.out.println("------------------------------");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    UsuarioBilletera usuarioLogueado;

                    usuarioLogueado = UsuarioBilletera.iniciarSesion(usuarios, scanner);
                    if (usuarioLogueado != null) {
                        usuarioLogueado.mostrarDatos();
                        usuarioLogueado.menu(scanner);
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }

                    break;
                case 2:
                    usuario.crearUsuario(usuarios, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                case 4:
                    System.out.print("Ingrese el RUT para filtrar usuarios: ");
                    String rut = scanner.next();
                    usuario.listarUsuariosPorRut(usuarios, rut);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
        scanner.close();
    }

}
