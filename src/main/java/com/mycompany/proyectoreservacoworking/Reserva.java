package com.mycompany.proyectoreservacoworking;

import java.io.Serializable;

public class Reserva implements Serializable {

    private static int nextId = 1;
    private int id;
    private String nombreUsuario;
    private String fechaReserva;
    private String espacioTrabajo;
    private int duracionReserva;

    public Reserva() {
        this.id = nextId++;
    }

    public Reserva(String nombreUsuario, String fechaReserva, String espacioTrabajo, int duracionReserva) {
        this.id = nextId++;
        this.nombreUsuario = nombreUsuario;
        this.fechaReserva = fechaReserva;
        this.espacioTrabajo = espacioTrabajo;
        this.duracionReserva = duracionReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEspacioTrabajo() {
        return espacioTrabajo;
    }

    public void setEspacioTrabajo(String espacioTrabajo) {
        this.espacioTrabajo = espacioTrabajo;
    }

    public int getDuracionReserva() {
        return duracionReserva;
    }

    public void setDuracionReserva(int duracionReserva) {
        this.duracionReserva = duracionReserva;
    }
}
