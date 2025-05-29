/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

/**
 *
 * @author VALERIA
 */
public class CuentaCredito extends CuentaBancaria {

    private int limiteCredito = 70000;

    public CuentaCredito(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito en cuenta de crédito: $" + monto);
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }

    @Override
    public void girar(int monto) {
        if (monto > 0 && (saldo - monto >= -limiteCredito)) {
            saldo -= monto;
            System.out.println("Giro realizado con crédito: $" + monto);
        } else {
            System.out.println("Excede el límite de crédito permitido.");
        }
    }

}
