package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();

        TodasLigas todasLigas = cargarDatosDesdeJSON("src/main/resources/ligas.json");

        context.setVariable("ligas", todasLigas.getLigas());

        String contingutHTML = templateEngine.process("plantilla1", context);
        System.out.println(contingutHTML);
        escriuHTML(contingutHTML, "src/main/resources/fitxerosWeb/index.html");

        for (Liga i : todasLigas.getLigas()) {

            Context context2 = new Context();
            context2.setVariable("equipos", i.getEquipos());
            String contingutEquipos = templateEngine.process("plantilla2", context2);

            String ruta = "src/main/resources/fitxerosWeb/equipos-" + i.getNombre() + ".html";
            escriuHTML(contingutEquipos, ruta);

        }

        RSS rss = new RSS();
        rss.generarRss(todasLigas);


    }

    public static TodasLigas cargarDatosDesdeJSON(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), TodasLigas.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void escriuHTML(String contingutHTML, String nomFitxer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer))) {
            writer.write(contingutHTML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
