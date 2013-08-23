
package integrador;


public class Egresado {
    private Long Id;
    private String Nombre ;
    private String Apellido;
    private String Correo;
    private Long Celular;
    Cuenta User_Cuenta;
    private int Telefono;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public long getCelular() {
        return Celular;
    }

    public void setCelular(Long Celular) {
        this.Celular = Celular;
    }

    public Cuenta getUser_Cuenta() {
        return User_Cuenta;
    }

    public void setUser_Cuenta(Cuenta User_Cuenta) {
        this.User_Cuenta = User_Cuenta;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    
    
    
}
