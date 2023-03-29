/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfase;

/**
 *
 * @author dell
 */
class User {
    private int id;
    private String Usuario;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Gmail;
    private String Clave;
    
    public User(int id, String Usuario, String Nombre, String Apellido, String Telefono, String Gmail, String Clave) {
        this.id = id;
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Gmail = Gmail;
        this.Clave = Clave;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getGmail() {
        return Gmail;
    }

    public String getClave() {
        return Clave;
    }
    
    
            
}
