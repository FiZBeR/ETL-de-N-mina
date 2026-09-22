package com.proyectotres.etldenomina.services;

import com.proyectotres.etldenomina.model.Empleado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ProcesadorArchivos {

    public List<Empleado> leerEmpleados(Path rutaEntrada){
        try {
            List<String> documento = Files.readAllLines(rutaEntrada);
            List<Empleado> docFinal = documento.stream()
                    .map(this::convertirEmpleado)
                    .filter(Objects::nonNull)
                    .toList();

            return docFinal;

        } catch (IOException e) {
            System.err.println("Error crítico al procesar el archivo: " + e.getMessage());
        }
        return List.of();
    }

    public Empleado convertirEmpleado(String linea){

        try {
            String[] partes = linea.split(",");

            int id = Integer.parseInt(partes[0].trim());
            String nombre = partes[1];
            double salario = Double.parseDouble(partes[2]);

            if(salario < 0.0){
                throw new IllegalArgumentException("Salario negativo, no valido");
            }

            String textoBono = partes[3].trim();
            Double bono = textoBono.equalsIgnoreCase("null") ? null : Double.parseDouble(textoBono);

            return new Empleado(id, nombre, salario, bono);

        } catch (IllegalArgumentException i){
            System.err.println(i);
            return null;
        }
    }

    public void generarReporte(List<String> reporteNuevo){
        try {

            Path rutaSalida = Path.of("src/reporte.txt");
            Files.write(rutaSalida, reporteNuevo);

        } catch (IOException i){
            System.err.println(i.getMessage());
        }
    }
}
