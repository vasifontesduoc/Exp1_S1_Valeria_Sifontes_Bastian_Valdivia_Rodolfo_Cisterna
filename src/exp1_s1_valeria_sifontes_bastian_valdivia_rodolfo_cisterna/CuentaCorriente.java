/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

/**
 *
 * @author VALERIA
 */
public class CuentaCorriente {

    private int numeroCuenta;
    private int saldo;
    private Cliente titular;

    public CuentaCorriente(int numeroCuenta, Cliente titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso: $" + monto);
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }

    public void girar(int monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Giro exitoso: $" + monto);
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
        }
    }
}
