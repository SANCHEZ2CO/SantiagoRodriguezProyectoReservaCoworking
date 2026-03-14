<%@page import="com.mycompany.proyectoreservacoworking.Reserva"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SZ2 - Lista de Reservas</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }

        .container {
            max-width: 900px;
            margin: 0 auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 10px;
            font-size: 2.5rem;
        }

        h2 {
            text-align: center;
            color: #666;
            font-size: 1rem;
            font-weight: normal;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }

        table thead {
            background-color: #4CAF50;
            color: white;
        }

        table th {
            padding: 12px;
            text-align: left;
            font-weight: bold;
        }

        table td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        table tbody tr:hover {
            background-color: #f9f9f9;
        }

        .no-reservas {
            text-align: center;
            padding: 40px;
            color: #666;
            font-size: 1.1rem;
        }

        .btn-eliminar {
            background-color: #f44336;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 0.9rem;
            transition: background-color 0.3s;
        }

        .btn-eliminar:hover {
            background-color: #da190b;
        }

        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
        }

        a.btn-link {
            display: inline-block;
            padding: 12px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        a.btn-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>SZ2</h1>
        <h2>Lista de Reservas</h2>

        <% 
            List<Reserva> listaReservas = (List<Reserva>) request.getServletContext().getAttribute("listaReservas");
            if (listaReservas != null && !listaReservas.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre de Usuario</th>
                        <th>Fecha de Reserva</th>
                        <th>Espacio de Trabajo</th>
                        <th>Duración (horas)</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for (Reserva reserva : listaReservas) {
                    %>
                    <tr>
                        <td><%= reserva.getId() %></td>
                        <td><%= reserva.getNombreUsuario() %></td>
                        <td><%= reserva.getFechaReserva() %></td>
                        <td><%= reserva.getEspacioTrabajo() %></td>
                        <td><%= reserva.getDuracionReserva() %></td>
                        <td>
                            <form action="EliminarReservaServlet" method="POST" style="display:inline;">
                                <input type="hidden" name="id" value="<%= reserva.getId() %>">
                                <button type="submit" class="btn-eliminar">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        <% 
            } else {
        %>
            <div class="no-reservas">
                <p>No hay reservas para mostrar.</p>
            </div>
        <% } %>

        <div class="button-group">
            <a href="index.html" class="btn-link">Hacer una nueva reserva</a>
        </div>
    </div>
</body>
</html>
