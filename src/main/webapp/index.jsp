<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>)session.getAttribute("listaest");
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
        
        <h1 align="center">REGISTRO DE CALFICACIONES</h1>
        <div align="center">
        <button><a href="MainControlador?op=nuevo">Nuevo</a></button>
        </div>
        <br>
        <table border="1" cellspacing="0" align="center">
            <tr>
                <th align="center">ID</th>
                <th>NOMBRE</th>
                <th align="center">P1(30)</th>
                <th align="center">P2(30)</th>
                <th align="center">EF(40)</th>
                <th align="center">NOTA</th>
                <th colspan="2" align="center">#</th>
            </tr>
            <%
                if(lista != null){
                    for(Estudiante item:lista){
            %>
        <tr>
            <td align="center"><%= item.getId() %></td>
            <td><%= item.getNombre() %></td>               
            <td align="center"><%= item.getP1() %></td>               
            <td align="center"><%= item.getP2() %></td>               
            <td align="center"><%= item.getEf() %></td> 
            <td align="center"><%= item.getP1()
                    +item.getP2()+item.getEf() %></td>
            <td align="center">
            <a href="MainControlador?op=editar&id=<%= item.getId() %>">Editar</a></td>
            <td align="center">
            <a href="MainControlador?op=eliminar&id=<%= item.getId() %>" 
            onclick='return confirm("Esta seguro de eliminar el registro?");'>Eliminar</a></td>
        </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
