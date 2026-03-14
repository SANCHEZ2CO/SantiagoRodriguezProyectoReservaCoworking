package com.mycompany.proyectoreservacoworking.servlets;

import com.mycompany.proyectoreservacoworking.Reserva;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarReservaServlet", urlPatterns = {"/EliminarReservaServlet"})
public class EliminarReservaServlet extends HttpServlet {

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

        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        List<Reserva> listaReservas = (List<Reserva>) getServletContext().getAttribute("listaReservas");

        if (listaReservas != null) {
            listaReservas.removeIf(reserva -> reserva.getId() == id);
        }

        response.sendRedirect("reservas.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para eliminar reservas";
    }
}
