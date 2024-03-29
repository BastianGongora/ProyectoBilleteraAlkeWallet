package org.alkewallet.AlkeWalletClases;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioBilleteraTest {


    @Test
    void listarUsuariosPorRut() {
        // Crear un ArrayList de Usuarios simulado
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Agregar usuarios de prueba al ArrayList
        UsuarioBilletera usuario1 = new UsuarioBilletera(1, "Juan Perez", "123", "123456789", new AlkeWalletImpl(100.0));
        UsuarioBilletera usuario2 = new UsuarioBilletera(2, "Alejandro Mora", "123", "987654321", new AlkeWalletImpl(200.0));
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        // Probar el método listarUsuariosPorRut con un RUT existente
        UsuarioBilletera usuarioBilletera = new UsuarioBilletera(0, "", "", "123456789", null);
        usuarioBilletera.listarUsuariosPorRut(usuarios, "123456789");
        // Verificar que se encuentre el usuario con el RUT especificado

    }
}