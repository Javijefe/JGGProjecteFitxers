package org.example;

import java.io.Serializable;
import java.util.List;

public class TodasLigas implements Serializable {
    List<Liga> ligas;

    public TodasLigas(List<Liga> ligas) {
        this.ligas = ligas;

    }

    public TodasLigas() {
    }

    public List<Liga> getLigas() {
        return ligas;
    }

    public void setLigas(List<Liga> ligas) {
        this.ligas = ligas;
    }

}
