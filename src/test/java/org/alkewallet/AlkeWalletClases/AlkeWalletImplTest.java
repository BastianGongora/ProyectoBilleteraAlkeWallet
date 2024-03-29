package org.alkewallet.AlkeWalletClases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlkeWalletImplTest {

    @Test
    void verSaldo() {
        // Crear una instancia de AlkeWalletImpl con un saldo inicial conocido
        AlkeWalletImpl alkeWallet = new AlkeWalletImpl(100.0);

        // Verificar que el saldo devuelto sea igual al saldo inicial
        assertEquals(100.0, alkeWallet.verSaldo());

    }

    @Test
    void realizarIngreso() {
        // Crear una instancia de AlkeWalletImpl con un saldo inicial conocido
        AlkeWalletImpl alkeWallet = new AlkeWalletImpl(100.0);

        // Realizar un ingreso de 50.0
        alkeWallet.realizarIngreso(50.0);

        // Verificar que el saldo aumentó correctamente
        assertEquals(150.0, alkeWallet.verSaldo());
    }

    @Test
    void realizarRetiro() {
        // Crear una instancia de AlkeWalletImpl con un saldo inicial conocido
        AlkeWalletImpl alkeWallet = new AlkeWalletImpl(100.0);

        // Realizar un retiro de 30.0
        alkeWallet.realizarRetiro(30.0);

        // Verificar que el saldo disminuyó correctamente
        assertEquals(70.0, alkeWallet.verSaldo());
    }

    @Test
    void convertirMoneda() {
        // Crear una instancia de AlkeWalletImpl con un saldo inicial conocido
        AlkeWalletImpl alkeWallet = new AlkeWalletImpl(1000.0);

        // Verificar que el método de conversión devuelve un arreglo con dos valores
        double[] conversion = alkeWallet.convertirMoneda();
        assertEquals(2, conversion.length);

        // Verificar que el primer valor sea el saldo convertido a dólares
        assertEquals(1.020408163265306, conversion[0], 0.01); // Redondeado a dos decimales

        // Verificar que el segundo valor sea el saldo convertido a euros
        assertEquals(0.9405426939700817, conversion[1], 0.01); // Redondeado a dos decimales

    }
}