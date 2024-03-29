package org.alkewallet.AlkeWalletClases;

/**
 * Implementación de la clase AlkeWallet que representa una billetera con funcionalidades específicas.
 * Esta implementación proporciona métodos concretos para ver el saldo, realizar ingresos y retiros de dinero,
 * y convertir el saldo a diferentes monedas.
 */
public class AlkeWalletImpl extends AlkeWallet {
    private static final double TasaUsd = 980; // Tasa de conversión a dólares
    private static final double TasaEur = 1063; // Tasa de conversión a euros

    /**
     * Constructor de la clase AlkeWalletImpl.
     *
     * @param saldoInicial Saldo inicial de la billetera.
     */
    public AlkeWalletImpl(double saldoInicial) {
        super(saldoInicial);
    }

    /**
     * Método para obtener el saldo actual de la billetera en la moneda base.
     *
     * @return Saldo actual de la billetera.
     */
    @Override
    public double verSaldo() {
        return saldo;
    }

    /**
     * Método para realizar un ingreso de dinero a la billetera.
     *
     * @param cantidad Cantidad de dinero a ingresar.
     */
    @Override
    public void realizarIngreso(double cantidad) {
        saldo += cantidad;
    }

    /**
     * Método para realizar un retiro de dinero de la billetera.
     *
     * @param cantidad Cantidad de dinero a retirar.
     */
    @Override
    public void realizarRetiro(double cantidad) {
        saldo -= cantidad;
    }

    /**
     * Método para convertir el saldo de la billetera a dólares y euros.
     *
     * @return Un arreglo de doubles que representa el saldo convertido en dólares y euros.
     */
    @Override
    public double[] convertirMoneda() {
        double saldoUsd = saldo / TasaUsd;
        double saldoEur = saldo / TasaEur;
        return new double[]{saldoUsd, saldoEur};
    }

}
