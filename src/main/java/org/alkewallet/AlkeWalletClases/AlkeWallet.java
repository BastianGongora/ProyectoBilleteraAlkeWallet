package org.alkewallet.AlkeWalletClases;

/**
 * Clase abstracta que representa una billetera.
 * Define operaciones básicas para manipular el saldo de la billetera.
 */
abstract class AlkeWallet {
    protected double saldo;// Saldo actual de la billetera

    /**
     * Constructor de la clase AlkeWallet.
     *
     * @param saldoInicial Saldo inicial de la billetera.
     */

    public AlkeWallet(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    /**
     * Método abstracto para obtener el saldo actual de la billetera.
     *
     * @return Saldo actual de la billetera.
     */
    public abstract double verSaldo();

    /**
     * Método abstracto para realizar un ingreso de dinero a la billetera.
     *
     * @param cantidad Cantidad de dinero a ingresar.
     */
    public abstract void realizarIngreso(double cantidad);

    /**
     * Método abstracto para realizar un retiro de dinero de la billetera.
     *
     * @param cantidad Cantidad de dinero a retirar.
     */
    public abstract void realizarRetiro(double cantidad);

    /**
     * Método abstracto para convertir el saldo de la billetera a diferentes monedas.
     *
     * @return Un arreglo de doubles que representa el saldo convertido en diferentes monedas.
     */
    public abstract double[] convertirMoneda();
}