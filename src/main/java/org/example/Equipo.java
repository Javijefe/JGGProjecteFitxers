package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Equipo implements Serializable {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("imagen")
    private String imagen;

    public Equipo() {
    }

    public Equipo(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
