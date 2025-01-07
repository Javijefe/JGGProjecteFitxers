package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class Liga implements Serializable {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("país")
    private String pais;

    @JsonProperty("equipos")
    private List<Equipo> equipos;

    public Liga() {
    }

    public Liga(String nombre, String pais, List<Equipo> equipos) {
        this.nombre = nombre;
        this.pais = pais;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Ligas{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", equipos=" + equipos +
                '}';
    }
}
