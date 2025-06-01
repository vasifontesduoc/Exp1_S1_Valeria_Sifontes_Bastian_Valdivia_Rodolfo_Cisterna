/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Bank_Boston {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Cliente cliente;

    private Cliente buscarClientePorRut(String rut) {
        String rutLimpio = limpiarRut(rut);
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rutLimpio)) {
                return c;
            }
        }
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void registrarCliente(CuentaBancaria cuenta) {
        System.out.println("\n=== REGISTRO DE CLIENTE ===");

        String rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, correo;

        System.out.print("Ingrese RUT (puede incluir puntos y guión): ");
        String rutInput = scanner.nextLine().trim();

        if (!rutInput.matches("^\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]$")) {
            System.out.println("⚠️ Formato de RUT inválido. Ejemplo válido: 20.345.678-0");
            return;
        }

        rut = limpiarRut(rutInput);

        if (buscarClientePorRut(rut) != null) {
            System.out.println("⚠️ El cliente con este RUT ya está registrado.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese apellido paterno: ");
        apellidoPaterno = scanner.nextLine();

        System.out.print("Ingrese apellido materno: ");
        apellidoMaterno = scanner.nextLine();

        System.out.print("Ingrese domicilio: ");
        domicilio = scanner.nextLine();

        System.out.print("Ingrese comuna: ");
        comuna = scanner.nextLine();

        System.out.print("Ingrese teléfono: ");
        telefono = scanner.nextLine();

        System.out.print("Ingrese correo electrónico: ");
        correo = scanner.nextLine();

        cliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, correo, cuenta);

        System.out.println("✅ Cliente registrado correctamente.");
    }

    public void girarDinero() {
        System.out.println("\n === GIRO DE DINERO ===");
        System.out.println("Ingrese su RUT: ");
        String rut = limpiarRut(scanner.nextLine());
        Cliente cliente = buscarClientePorRut(rut);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        CuentaBancaria cuenta = cliente.getCuenta();

        System.out.print("Ingrese monto a girar: ");
        int monto;
        try {
            monto = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: debe ingresar un número válido.");
            scanner.nextLine();
            return;
        }

        if (monto <= 0) {
            System.out.println("❌ El monto debe ser mayor a cero.");
            return;
        }

        if (cuenta.getSaldo() < monto) {
            System.out.println("❌ Saldo insuficiente.");
            return;
        }

        cuenta.girar(monto);
        System.out.println("✅ Giro realizado con éxito. Saldo actual: $" + cuenta.getSaldo());
    }

    public void consultarSaldo() {
        System.out.println("\n=== CONSULTA DE SALDO ===");
        System.out.println("\nIngrese su RUT: ");
        String rut = limpiarRut(scanner.nextLine());
        Cliente cliente = buscarClientePorRut(rut);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.println("Saldo actual: $" + cliente.getCuenta().getSaldo());
    }

    private String limpiarRut(String rutInput) {
        return rutInput.replaceAll("[^\\dkK]", ""); // Elimina puntos y guión
    }

    public void verDatosCliente() {
        if (clientes.isEmpty()) {
            System.out.println("\n⚠️ No hay clientes registrados aún.");
            return;
        }

        System.out.print("\nIngrese el RUT del cliente a consultar: ");
        String rutInput = scanner.nextLine().trim();
        String rutBuscado = limpiarRut(rutInput);

        Cliente clienteEncontrado = buscarClientePorRut(rutBuscado);

        if (clienteEncontrado != null) {
            System.out.println("\n=== DATOS DEL CLIENTE ===");
            System.out.println("RUT: " + clienteEncontrado.getRut());
            System.out.println("Nombre: " + clienteEncontrado.getNombre());
            System.out.println("Apellido Paterno: " + clienteEncontrado.getApellidoPaterno());
            System.out.println("Apellido Materno: " + clienteEncontrado.getApellidoMaterno());
            System.out.println("Domicilio: " + clienteEncontrado.getDomicilio());
            System.out.println("Comuna: " + clienteEncontrado.getComuna());
            System.out.println("Teléfono: " + clienteEncontrado.getTelefono());
            System.out.println("Correo: " + clienteEncontrado.getCorreo());
            System.out.println("Número de Cuenta: " + clienteEncontrado.getCuenta().getNumeroCuenta());
            System.out.println("Saldo actual: $" + clienteEncontrado.getCuenta().getSaldo());
        } else {
            System.out.println("\n Cliente no encontrado con ese RUT.");
        }
    }

    public void depositarDinero() {
        if (clientes.isEmpty()) {
            System.out.println("⚠️ No hay clientes registrados.");
            return;
        }

        System.out.print("Ingrese su RUT para depositar dinero: ");
        String rutInput = scanner.nextLine().trim();
        String rutBuscado = limpiarRut(rutInput);

        Cliente clienteEncontrado = buscarClientePorRut(rutBuscado);

        if (clienteEncontrado == null) {
            System.out.println("❌ Cliente no encontrado. Debe registrar un cliente antes de realizar un depósito.");
            return;
        }

        CuentaBancaria cuenta = clienteEncontrado.getCuenta();

        try {
            System.out.println("========================================");
            System.out.println("        💰 DEPÓSITO DE DINERO");
            System.out.println("========================================");
            System.out.println("¿Desea depositar a:");
            System.out.println("1️⃣  Usted mismo");
            System.out.println("2️⃣  Un tercero");
            System.out.println("0️⃣  Volver");
            System.out.print("Seleccione una opción: ");
            int opcionDeposito = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcionDeposito == 0) {
                System.out.println("↩️ Volviendo al menú principal...");
                return;
            }

            switch (opcionDeposito) {
                case 1:
                    System.out.print("Ingrese el monto a depositar o '0' para volver: ");
                    int monto = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    if (monto == 0) {
                        System.out.println("↩️ Volviendo al menú principal...");
                        return;
                    }
                    if (monto < 0) {
                        System.out.println("❌ Monto inválido.");
                    } else {
                        cuenta.depositar(monto);
                        System.out.println("✅ Depósito realizado con éxito.");
                        System.out.println("📄 Comprobante: Depósito de $" + monto + " a su cuenta.");
                    }
                    break;
                case 2:
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Ingrese nombre del destinatario (o escriba VOLVER): ");
                    String nombreDestinatario = scanner.nextLine();
                    if (nombreDestinatario.equalsIgnoreCase("VOLVER") || nombreDestinatario.isEmpty()) {
                        System.out.println("↩️ Volviendo...");
                        return;
                    }
                    System.out.print("Ingrese RUT del destinatario: ");
                    String rutDestinatario = scanner.nextLine();
                    if (rutDestinatario.isEmpty()) {
                        System.out.println("❌ RUT no puede estar vacío.");
                        return;
                    }
                    System.out.print("Ingrese banco destino: ");
                    String bancoDestino = scanner.nextLine();
                    if (bancoDestino.isEmpty()) {
                        System.out.println("❌ Banco no puede estar vacío.");
                        return;
                    }
                    System.out.println("Seleccione el tipo de cuenta destino:");
                    System.out.println("1️⃣  Cuenta Corriente");
                    System.out.println("2️⃣  Cuenta de Ahorro");
                    System.out.println("3️⃣  Cuenta de Crédito");
                    System.out.println("0️⃣  Volver");
                    System.out.print("Ingrese una opción: ");
                    int tipoCuenta = scanner.nextInt();
                    if (tipoCuenta == 0) {
                        System.out.println("↩️ Volviendo al menú...");
                        return;
                    }
                    CuentaBancaria cuentaDestino;
                    switch (tipoCuenta) {
                        case 1:
                            cuentaDestino = new CuentaCorriente(999999);
                            break;
                        case 2:
                            cuentaDestino = new CuentaAhorro(999999);
                            break;
                        case 3:
                            cuentaDestino = new CuentaCredito(999999);
                            break;
                        default:
                            System.out.println("❌ Opción inválida.");
                            return;
                    }
                    System.out.print("Ingrese el monto a depositar o '0' para volver: ");
                    int montoTercero = scanner.nextInt();
                    if (montoTercero == 0) {
                        System.out.println("↩️ Volviendo...");
                        return;
                    }
                    if (montoTercero < 0) {
                        System.out.println("❌ Monto inválido.");
                    } else {
                        cuentaDestino.depositar(montoTercero);
                        System.out.println("✅ Depósito realizado con éxito.");
                        System.out.println("📄 Comprobante:");
                        System.out.println("Destinatario: " + nombreDestinatario);
                        System.out.println("RUT: " + rutDestinatario);
                        System.out.println("Banco destino: " + bancoDestino);
                        System.out.println("Tipo de cuenta destino: " + cuentaDestino.getClass().getSimpleName());
                        System.out.println("Monto depositado: $" + montoTercero);
                    }
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: debe ingresar un número válido.");
            scanner.nextLine(); // limpiar buffer
        }
    }

    public void cambiarTipoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del cliente para cambiar su cuenta: ");
        String rut = scanner.nextLine();
        Cliente clienteEncontrado = buscarClientePorRut(rut);

        if (clienteEncontrado != null) {
            CuentaBancaria nuevaCuenta = null;
            boolean cuentaSeleccionada = false;

            while (!cuentaSeleccionada) {
                System.out.println("Seleccione el nuevo tipo de cuenta:");
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
                            nuevaCuenta = new CuentaCorriente(numeroCuenta);
                            cuentaSeleccionada = true;
                            break;
                        case 2:
                            nuevaCuenta = new CuentaAhorro(numeroCuenta);
                            cuentaSeleccionada = true;
                            break;
                        case 3:
                            nuevaCuenta = new CuentaCredito(numeroCuenta);
                            cuentaSeleccionada = true;
                            break;
                        default:
                            System.out.println("❌ Opción inválida.");
                    }
                } else {
                    System.out.println("❌ Entrada inválida.");
                    scanner.nextLine();
                }
            }

            cliente.setCuenta(nuevaCuenta);
            System.out.println("✅ Cuenta cambiada exitosamente para " + cliente.getNombre());
        } else {
            System.out.println("❌ Cliente no encontrado.");
        }
    }


    public int leerEntero(String mensaje) {
        int num = 0;
        boolean error;
        do {
            System.out.print(mensaje);
            try {
                num = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: debe ingresar un número válido.");
                scanner.nextLine(); // limpiar buffer
                error = true;
            }
        } while (error);
        return num;
    }
}