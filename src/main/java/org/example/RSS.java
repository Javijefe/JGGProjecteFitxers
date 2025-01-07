package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class RSS {

    public void generarRss(TodasLigas todasLigas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/RSS/rss.xml"))) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            writer.write("<rss version=\"2.0\">");
            writer.write("<channel>");
            writer.write("<title>Detalles de las Ligas</title>");
            writer.write(" <link>https://www.trabajoJaume.com</link>");
            writer.write("<description>Información sobre las liga y sus equipos</description>\n");
            writer.write("<language>es</language>");

            for (Liga liga : todasLigas.getLigas()) {
                writer.write("<item>");
                writer.write("<title>" + liga.getNombre() + "</title>");
                writer.write("<link> " + "equipos-" + liga.getNombre() + ".html" + " </link>");
                writer.write("<description>Ver detalles de la liga española, equipos y más.</description>\n");
                writer.write("</item>");

                for (Equipo equipo : liga.getEquipos()) {
                    writer.write("<item>");
                    writer.write("<title>" + equipo.getNombre() + "</title>");
                    writer.write("</item>");

                }
            }
            writer.write("</channel>");
            writer.write("</rss>");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
