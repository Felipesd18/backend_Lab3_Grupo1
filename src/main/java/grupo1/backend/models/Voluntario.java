package grupo1.backend.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import grupo1.backend.models.Habilidad;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("voluntario")
public class Voluntario {
    @Id
    private String id;
    @Field(name = "nombre")
    private String nombre;
    @Field(name = "correo")
    private String correo;
    @Field(name = "edad")
    private int edad;
    @Field(name = "longitud")
    private float longitud;
    @Field(name = "latitud")
    private float latitud;
    @Field(name = "habilidades")
    private ArrayList<Habilidad> habilidades;

   

    public Voluntario(String id, String nombre, String correo, int edad, float longitud, float latitud, ArrayList<Habilidad> habilidades) {

        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.longitud = longitud;
        this.latitud = latitud;
        this.habilidades = habilidades;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

}
