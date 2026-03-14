package com.mycompany.proyectoreservacoworking.servlets;

import com.mycompany.proyectoreservacoworking.Reserva;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getParameter("nombre");
        String fechaReserva = request.getParameter("fecha");
        String espacioTrabajo = request.getParameter("espacio");
        String duracionStr = request.getParameter("duracion");

        if (nombreUsuario == null || nombreUsuario.isEmpty() || fechaReserva == null || fechaReserva.isEmpty() || espacioTrabajo == null || espacioTrabajo.isEmpty() || duracionStr == null || duracionStr.isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }

        int duracionReserva = 0;
        try {
            duracionReserva = Integer.parseInt(duracionStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "La duración de la reserva debe ser un número.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }

        Reserva nuevaReserva = new Reserva(nombreUsuario, fechaReserva, espacioTrabajo, duracionReserva);

        ServletContext context = getServletContext();
        List<Reserva> listaReservas = (List<Reserva>) context.getAttribute("listaReservas");

        if (listaReservas == null) {
            listaReservas = new ArrayList<>();
        }

        listaReservas.add(nuevaReserva);
        context.setAttribute("listaReservas", listaReservas);

        response.sendRedirect("reservas.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para procesar reservas";
    }
}
