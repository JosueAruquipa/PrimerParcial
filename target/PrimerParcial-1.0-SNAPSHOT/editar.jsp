<%@page import="com.emergentes.modelo.Estudiante"%>

<%
    Estudiante item = (Estudiante) request.getAttribute("estudiante");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primer Parcial - Josue Aruquipa</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td>
            <fieldset style="width:300px" style="align: center;">
                <p align="center">PRIMER PARCIAL TEM - 742</p>
                <p>Nombre: Josue Vidal Aruquipa Quispe<br>
                    Carnet: 6056889</p>
            </fieldset>
                </td>
            </tr>
        </table>
    <h1 align="center"><%= (item.getId() == 0) ? 
        "Registro de calificaciones" : "Modificar calificaciones" %></h1>
    <form action="MainControlador" method="post">
    <input type="hidden" name="id" value="<%= item.getId() %>"/>
        <table align="center">
            <tr>
                <td align="right">Nombre del estudiante:</td> 
                <td><input type="text" name="nombre" 
                           value="<%= item.getNombre() %>"/></td>
            </tr>
            <tr>
                <td align="right">Primer parcial (sobre 30 pts):</td>
                <td><input type="number" max="30" name="p1" 
                           value="<%= item.getP1() %>"/></td>
            </tr>
            <tr>
                <td align="right">Segundo parcial (sobre 30 pts):</td>
                <td><input type="number" max="30" name="p2" 
                           value="<%= item.getP2() %>"/></td>
            </tr>
            <tr>
                <td align="right">Examen final (sobre 40 pts):</td>
                <td><input type="number" max="40" name="ef" 
                           value="<%= item.getEf() %>"/></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" 
                value="<%= (item.getId() == 0) ? 
                "Enviar calificaciones" : "Actualizar calificaciones" %>"></td>
            </tr>
        </table>
        </form>
    </body>
</html>
