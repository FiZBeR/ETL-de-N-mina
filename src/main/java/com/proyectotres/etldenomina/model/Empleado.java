package com.proyectotres.etldenomina.model;

public class Empleado {

    private int id;
    private String nombre;
    private double salarioBase;
    private Double bonoAdicional;

    public Empleado(int id, String nombre, double salarioBase, Double bonoAdicional) {
        this.id = id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.bonoAdicional = bonoAdicional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getBonoAdicional() {
        return bonoAdicional;
    }

    public void setBonoAdicional(Double bonoAdicional) {
        this.bonoAdicional = bonoAdicional;
    }

    public static double calcularSalarioTotal(double salarioBase, Double bonoAdicional){
        if(bonoAdicional == null){
            return salarioBase;
        } else {
            return salarioBase + bonoAdicional;
        }
    }

    public static String reporte(Empleado empl){
        double salarioFinal = calcularSalarioTotal(empl.getSalarioBase(), empl.getBonoAdicional());
        return "ID: " + empl.getId() + ", Nombre: " + empl.getNombre() + ", Salario Total: $" + salarioFinal;
    }


}
