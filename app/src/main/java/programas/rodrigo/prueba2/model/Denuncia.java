package programas.rodrigo.prueba2.model;

public class Denuncia {

    private String id;
    private String titulo;
    private String direccion;

    public Denuncia(){

    }

    public Denuncia(String id, String titulo, String direccion) {
        this.id = id;
        this.titulo = titulo;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
