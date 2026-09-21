package com.proyectotres.etldenomina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class EtlDeNominaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EtlDeNominaApplication.class, args);

        Path rutaEntrada = Path.of("src/nomina.txt");

        ProcesadorArchivos pr = new ProcesadorArchivos();

        List<Empleado> doc = pr.leerEmpleados(rutaEntrada);

        Empleado prueba = doc.get(0);

        System.out.println("ID: " + prueba.getId() + " Nombre: " + prueba.getNombre() + " Salario: $" + prueba.getSalarioBase() + " Bono: $" + prueba.getBonoAdicional());
    }

}
