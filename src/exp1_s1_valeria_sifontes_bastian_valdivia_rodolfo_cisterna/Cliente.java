/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_valeria_sifontes_bastian_valdivia_rodolfo_cisterna;

/**
 *
 * @author VALERIA
 */
public class Cliente implements Mostrable {

    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private String correo;
    private CuentaBancaria cuenta;

    // constructor
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String telefono, String correo, CuentaBancaria cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.correo = correo;
        this.cuenta = cuenta;
    }

    // getters y setters
    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut != null) {
            // Eliminar puntos y guiones, mantener números y letra K/k
            String rutLimpio = rut.replaceAll("[^\\dkK]", "");

            // Validar que termine en número o K
            if (!rutLimpio.matches("\\d{7,10}[kK\\d]")) {
                System.out.println("⚠️ RUT inválido. Debe tener entre 8 y 11 dígitos más verificador (número o K).");
                this.rut = "000000000000";
                return;
            }

            // Rellenar con ceros hasta completar 12 caracteres
            while (rutLimpio.length() < 12) {
                rutLimpio = "0" + rutLimpio;
            }

            this.rut = rutLimpio.toUpperCase();
        } else {
            System.out.println("⚠️ RUT nulo.");
            this.rut = "000000000000";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public void mostrarDatosCliente() {
        System.out.println("\n===== DATOS DEL CLIENTE =====");
        System.out.println("RUT         : " + rut);
        System.out.println("Nombre      : " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Domicilio   : " + domicilio);
        System.out.println("Comuna      : " + comuna);
        System.out.println("Teléfono    : " + telefono);
        System.out.println("Correo      : " + correo);
        System.out.println("N° Cuenta   : " + (cuenta != null ? cuenta.getNumeroCuenta() : "Sin asignar"));
        System.out.println("Saldo       : $" + (cuenta != null ? cuenta.getSaldo() : 0));
        System.out.println("Tipo Cuenta : " + (cuenta != null ? cuenta.getClass().getSimpleName() : "N/A"));
    }
}
