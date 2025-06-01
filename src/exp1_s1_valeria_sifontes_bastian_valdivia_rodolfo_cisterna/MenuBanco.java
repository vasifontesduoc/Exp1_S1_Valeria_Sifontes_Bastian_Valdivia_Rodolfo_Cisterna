/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

import java.util.Scanner;

/**
 *
 * @author VALERIA
 */
public class MenuBanco {

    private Bank_Boston banco = new Bank_Boston();

    public void mostrar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        CuentaBancaria cuenta = null;

        do {
            System.out.println("\n========================================");
            System.out.println("        BANK BOSTON - MENÚ PRINCIPAL      ");
            System.out.println("========================================");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Ver datos del cliente");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Realizar giro");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Cambiar tipo de cuenta");
            System.out.println("7. Salir del programa");
            System.out.println("========================================");
            System.out.print("Seleccione una opción (1-7): ");

            while (!scanner.hasNextInt()) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número.");
                System.out.print("Seleccione una opción (1-7): ");
                scanner.nextLine();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cuenta = seleccionarTipoCuenta(scanner);
                    if (cuenta != null) {
                        banco.registrarCliente(cuenta);
                    }
                    break;

                case 2:
                    banco.verDatosCliente();
                    break;

                case 3:
                    banco.depositarDinero();
                    break;

                case 4:
                    banco.girarDinero();
                    break;

                case 5:
                    banco.consultarSaldo();
                    break;

                case 6:
                    System.out.println("🔁 Cambio de tipo de cuenta para cliente existente.");
                    banco.cambiarTipoCuenta();
                    break;

                case 7:
                    System.out.println("👋 ¡Gracias por usar Bank Boston!");
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 7);
    }

    private CuentaBancaria seleccionarTipoCuenta(Scanner scanner) {
        boolean cuentaSeleccionada = false;
        CuentaBancaria cuenta = null;

        while (!cuentaSeleccionada) {
            System.out.println("========================================");
            System.out.println("       ✨ SELECCIONE EL TIPO DE CUENTA ✨");
            System.out.println("========================================");
            System.out.println("1. Cuenta Corriente");
            System.out.println("2. Cuenta de Ahorro");
            System.out.println("3. Cuenta de Crédito");
            System.out.print("Ingrese una opción (1-3): ");

            if (scanner.hasNextInt()) {
                int tipoCuenta = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                int numeroCuenta = (int) (Math.random() * 1000000);

                switch (tipoCuenta) {
                    case 1:
                        cuenta = new CuentaCorriente(numeroCuenta);
                        cuentaSeleccionada = true;
                        break;
                    case 2:
                        cuenta = new CuentaAhorro(numeroCuenta);
                        cuentaSeleccionada = true;
                        break;
                    case 3:
                        cuenta = new CuentaCredito(numeroCuenta);
                        cuentaSeleccionada = true;
                        break;
                    default:
                        System.out.println("❌ Opción inválida.");
                }
            } else {
                System.out.println("❌ Entrada inválida. Debe ingresar un número.");
                scanner.nextLine(); // limpiar entrada
            }
        }

        return cuenta;
    }
}
