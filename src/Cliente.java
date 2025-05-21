/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VALERIA
 */
public class Cliente {

    private String nombre, apellido, rut, telefono, email, tipoCliente;

    // constructor
    public Cliente(String nombre, String apellido, String rut, String telefono, String email, String tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", rut='" + rut + '\''
                + ", telefono='" + telefono + '\''
                + ", email='" + email + '\''
                + ", tipoCliente='" + tipoCliente + '\''
                + '}';
    }
}
