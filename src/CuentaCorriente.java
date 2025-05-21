/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VALERIA
 */
public class CuentaCorriente {
    private int numeroCuenta, saldo;
    
    // constructor
    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }
    
    // getters y setters

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    // primer método para depositar dinero
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("¡Depósito realizado con éxito!");
            System.out.println("Usted tiene un saldo actual de: " + saldo + " pesos.");
        } else {
            System.out.println("El monto debe ser mayor a cero.");
        }
    }
    
    // segundo método para girar dinero
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto a girar debe ser mayor que cero.");
        } else if (monto > saldo) {
            System.out.println("Saldo insuficiente para realizar el giro");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado con éxito!");
            System.out.println("Usted tiene un saldo actual de: " + saldo + " pesos.");
        }
    }
    
    // tercer método para consultar el saldo
    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo + " pesos.");
    }
}
