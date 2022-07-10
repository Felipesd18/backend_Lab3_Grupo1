package grupo1.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("habilidad")
public class Habilidad {

    @Id
    private String id;
    @Field(name = "descripcion")
    private String descripcion;
    @Field(name = "codigo")
    private String codigo;

    public Habilidad(String id, String descripcion, String codigo) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
