/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

/**
 *
 * @author VALERIA
 */
public abstract class CuentaBancaria {

    protected int numeroCuenta;
    protected int saldo;

    // constructor base
    public CuentaBancaria(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    // Constructor con saldo inicial
    public CuentaBancaria(int numeroCuenta, int saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Getters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    // Método común
    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    // Métodos abstractos
    public abstract void depositar(int monto);

    public abstract void girar(int monto);
}
