package programas.rodrigo.prueba2.model;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String uid;


    public Usuario(){

    }

    public Usuario(String id, String nombre, String email, String uid) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
