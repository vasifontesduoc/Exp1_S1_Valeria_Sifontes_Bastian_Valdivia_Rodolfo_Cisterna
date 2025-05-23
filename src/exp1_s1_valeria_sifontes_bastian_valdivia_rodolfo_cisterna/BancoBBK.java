/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VALERIA
 */
public class BancoBBK {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void registrarCliente() {
        System.out.println("\n=== REGISTRO DE CLIENTE ===");

        System.out.print("Ingrese RUT (sin puntos, con guión: ");
        String rut = scanner.nextLine().trim();

        while (!rut.matches("^\\d{7,8}-[\\dkK]$")) {
            System.out.print("⚠️ RUT inválido. Ingrese nuevamente: ");
            rut = scanner.nextLine().trim();
        }

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese apellido paterno: ");
        String apellidoPaterno = scanner.nextLine();

        System.out.print("Ingrese apellido materno: ");
        String apellidoMaterno = scanner.nextLine();

        System.out.print("Ingrese domicilio: ");
        String domicilio = scanner.nextLine();

        System.out.print("Ingrese comuna: ");
        String comuna = scanner.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        int numeroCuenta = (int) (Math.random() * 900_000_000) + 100_000_000;

        Cliente cliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, correo);
        CuentaCorriente cuenta = new CuentaCorriente(numeroCuenta, cliente);
        cliente.setCuenta(cuenta);

        clientes.add(cliente);

        System.out.println("\n✅ Cliente registrado exitosamente.");
        System.out.println("N° de cuenta asignado: " + numeroCuenta);
    }

    public void verDatosCliente() {
        if (clientes.isEmpty()) {
            System.out.println("\n⚠️ No hay clientes registrados aún.");
            return;
        }

        System.out.print("\nIngrese el RUT del cliente a consultar: ");
        String rutBuscado = scanner.nextLine().trim();

        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rutBuscado)) {
                System.out.println("\n=== DATOS DEL CLIENTE ===");
                System.out.println(c.mostrarDatos());
                System.out.println("Saldo actual: $" + c.getCuenta().getSaldo());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n⚠️ Cliente no encontrado con ese RUT.");
        }
    }

    public void menuDeposito() {
        if (clientes.isEmpty()) {
            System.out.println("\n⚠️ No hay clientes registrados.");
            return;
        }

        System.out.print("\nIngrese su RUT para continuar: ");
        String rut = scanner.nextLine().trim();

        Cliente remitente = null;
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rut)) {
                remitente = c;
                break;
            }
        }

        if (remitente == null) {
            System.out.println("⚠️ Cliente no encontrado.");
            return;
        }

        int opcionDeposito;
        do {
            System.out.println("\n=== DEPÓSITO ===");
            System.out.println("1. Depositar en mi propia cuenta");
            System.out.println("2. Depositar a otra cuenta (tercero)");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionDeposito = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcionDeposito) {
                case 1:
                    depositarPropio(remitente);
                    break;
                case 2:
                    depositarATercero(remitente);
                    break;
                case 3:
                    System.out.println("↩ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");
            }

        } while (opcionDeposito != 3);
    }

    private void depositarPropio(Cliente cliente) {
        System.out.println("Saldo actual: $" + cliente.getCuenta().getSaldo());
        int monto = leerEntero("Ingrese monto a depositar en su cuenta (0 para cancelar): ");

        if (monto == 0) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        if (monto < 0) {
            System.out.println("⚠️ El monto debe ser mayor que cero.");
            return;
        }

        cliente.getCuenta().depositar(monto);

        System.out.println("✅ Depósito exitoso en su cuenta.");
        System.out.println("Nuevo saldo: $" + cliente.getCuenta().getSaldo());
    }

    private void depositarATercero(Cliente remitente) {
        int saldoDisponible = remitente.getCuenta().getSaldo();

        if (saldoDisponible <= 0) {
            System.out.println("⚠️ No puede transferir: su saldo es $0.");
            return;
        }

        System.out.println("Saldo actual: $" + saldoDisponible);
        System.out.println("(Ingrese 0 en cualquier momento para cancelar)");

        System.out.print("Ingrese nombre del destinatario: ");
        String nombreDestinatario = scanner.nextLine();
        if (nombreDestinatario.equals("0")) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        System.out.print("Ingrese RUT del destinatario: ");
        String rutDestinatario = scanner.nextLine();
        if (rutDestinatario.equals("0")) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        System.out.print("Ingrese banco de destino: ");
        String bancoDestino = scanner.nextLine();
        if (bancoDestino.equals("0")) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        System.out.print("Ingrese número de cuenta de destino: ");
        String cuentaDestino = scanner.nextLine();
        if (cuentaDestino.equals("0")) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        int monto = leerEntero("Ingrese monto a transferir (0 para cancelar): ");
        if (monto == 0) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        if (monto < 0) {
            System.out.println("⚠️ El monto debe ser mayor que cero.");
            return;
        }

        if (monto > saldoDisponible) {
            System.out.println("⚠️ No tiene saldo suficiente para esta transferencia.");
            return;
        }

        remitente.getCuenta().girar(monto);

        System.out.println("✅ Transferencia realizada exitosamente.");
        System.out.println("Monto: $" + monto);
        System.out.println("Destinatario: " + nombreDestinatario);
        System.out.println("Cuenta: " + cuentaDestino + " | Banco: " + bancoDestino);
        System.out.println("Saldo restante en su cuenta: $" + remitente.getCuenta().getSaldo());
    }

    public void girarDinero() {
        if (clientes.isEmpty()) {
            System.out.println("\n⚠️ No hay clientes registrados.");
            return;
        }

        System.out.print("\nIngrese su RUT para realizar un giro: ");
        String rut = scanner.nextLine().trim();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rut)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("⚠️ Cliente no encontrado.");
            return;
        }

        int saldo = cliente.getCuenta().getSaldo();

        if (saldo <= 0) {
            System.out.println("⚠️ No puede girar: su saldo es $0.");
            return;
        }

        System.out.println("\n=== GIRO DE DINERO ===");
        System.out.println("Saldo disponible: $" + saldo);
        int monto = leerEntero("Ingrese monto a girar (0 para cancelar): ");

        if (monto == 0) {
            System.out.println("↩ Operación cancelada.");
            return;
        }

        if (monto < 0) {
            System.out.println("⚠️ El monto debe ser mayor que cero.");
            return;
        }

        if (monto > saldo) {
            System.out.println("⚠️ No tiene suficiente saldo para este giro.");
            return;
        }

        cliente.getCuenta().girar(monto);
        int nuevoSaldo = cliente.getCuenta().getSaldo();
        int maxGiro = nuevoSaldo;

        // ✅ Preguntar si quiere comprobante
        int imprimir;
        do {
            System.out.print("\n¿Desea descargar comprobante? (1 = Sí / 2 = No): ");
            imprimir = leerEntero("");

            if (imprimir == 1) {
                System.out.println("\n========================================");
                System.out.println("            COMPROBANTE DE GIRO         ");
                System.out.println("========================================");
                System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellidoPaterno());
                System.out.println("RUT: " + cliente.getRut());
                System.out.println("----------------------------------------");
                System.out.println("Monto girado      : $" + monto);
                System.out.println("Saldo actual      : $" + nuevoSaldo);
                System.out.println("Máximo a girar    : $" + maxGiro);
                System.out.println("Fecha/Hora        : " + java.time.LocalDateTime.now());
                System.out.println("========================================");
            } else if (imprimir != 2) {
                System.out.println("⚠️ Opción inválida.");
            }
        } while (imprimir != 1 && imprimir != 2);

        // ✅ Preguntar si desea volver o salir
        int opcion;
        do {
            System.out.print("\n¿Desea volver al menú principal? (1 = Sí / 2 = No): ");
            opcion = leerEntero("");

            if (opcion == 1) {
                System.out.println("↩ Regresando al menú principal...");
            } else if (opcion == 2) {
                System.out.println("👋 Sesión finalizada. Gracias por preferir Banco BBK.");
                System.exit(0);
            } else {
                System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 1);

    }

    private int leerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                return valor;
            } else {
                System.out.println("⚠️ Entrada inválida. Ingrese un número entero.");
                scanner.nextLine(); // limpiar input inválido
            }
        }
    }

    public void consultarSaldo() {
        if (clientes.isEmpty()) {
            System.out.println("\n⚠️ No hay clientes registrados.");
            return;
        }

        System.out.print("\nIngrese su RUT para consultar el saldo: ");
        String rut = scanner.nextLine().trim();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rut)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("⚠️ Cliente no encontrado.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("          CONSULTA DE SALDO             ");
        System.out.println("========================================");
        System.out.println("Cliente       : " + cliente.getNombre() + " " + cliente.getApellidoPaterno());
        System.out.println("N° Cuenta     : " + cliente.getCuenta().getNumeroCuenta());
        System.out.println("Saldo Actual  : $" + cliente.getCuenta().getSaldo());
        System.out.println("Fecha/Hora    : " + java.time.LocalDateTime.now());
        System.out.println("========================================");

        // Pregunta para volver o salir
        int opcion;
        do {
            System.out.print("\n¿Desea volver al menú principal? (1 = Sí / 2 = No): ");
            opcion = leerEntero("");

            if (opcion == 1) {
                System.out.println("↩ Regresando al menú principal...");
            } else if (opcion == 2) {
                System.out.println("👋 Sesión finalizada. Gracias por preferir Banco BBK.");
                System.exit(0);
            } else {
                System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 1);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}