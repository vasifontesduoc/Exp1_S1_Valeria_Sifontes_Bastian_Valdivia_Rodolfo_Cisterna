/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

/**
 *
 * @author VALERIA
 */
public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito en cuenta corriente: $" + monto);
        } else {
            System.out.println("Monto inválido.");
        }
    }

    @Override
    public void girar(int monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Giro exitoso de $" + monto);
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
        }
    }
}
