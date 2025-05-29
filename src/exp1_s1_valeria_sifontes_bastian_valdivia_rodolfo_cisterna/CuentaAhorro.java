/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

/**
 *
 * @author VALERIA
 */
public class CuentaAhorro extends CuentaBancaria {

    public CuentaAhorro(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito en cuenta de ahorro: $" + monto);
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }

    @Override
    public void girar(int monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Giro desde cuenta de ahorro: $" + monto);
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
        }
    }
}
