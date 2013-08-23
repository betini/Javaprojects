package integrador;


public class Empresa {

 private String nombre;
 private int codnum;
 private String direccion;
 private Long celular;
 private int telefono;
 Cuenta User_Cuenta;
 private String contacto;

    public Cuenta getUser_Cuenta() {
        return User_Cuenta;
    }

    public void setUser_Cuenta(Cuenta User_Cuenta) {
        this.User_Cuenta = User_Cuenta;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public int getCodnum() {
        return codnum;
    }

    public void setCodnum(int codnum) {
        this.codnum = codnum;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }




 


}