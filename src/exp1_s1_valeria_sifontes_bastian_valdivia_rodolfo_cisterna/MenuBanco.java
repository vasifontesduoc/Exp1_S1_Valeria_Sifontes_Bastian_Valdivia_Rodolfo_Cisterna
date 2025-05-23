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

    private BancoBBK banco = new BancoBBK();

    public void mostrar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("        BANCO BBK - MENÚ PRINCIPAL      ");
            System.out.println("========================================");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Ver datos del cliente");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Realizar giro");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opción (1-6): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    banco.registrarCliente();
                    break;

                case 2:
                    banco.verDatosCliente();
                    break;

                case 3:
                    banco.menuDeposito();
                    break;

                case 4:
                    banco.girarDinero();
                    break;

                case 5:
                    banco.consultarSaldo();
                    break;

                case 6:
                    System.out.println("\nGracias por usar Banco BBK. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
