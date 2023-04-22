
package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josué
 */
@WebServlet(name = "MainControlador", urlPatterns = {"/MainControlador"})
public class MainControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          HttpSession ses = request.getSession();

        if (ses.getAttribute("listaest") == null) {
            ArrayList<Estudiante> listaux = new ArrayList<Estudiante>();
            ses.setAttribute("listaest", listaux);
        }
        
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaest");
        
        String op = request.getParameter("op");
        String opcion = (op != null) ? request.getParameter("op") : "view";
        
        Estudiante est1 = new Estudiante();
        int id, pos;
        
        
        switch(opcion){
            case "nuevo":
                request.setAttribute("estudiante", est1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                est1 = lista.get(pos);
                request.setAttribute("estudiante", est1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                pos = buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listaest", lista);
                response.sendRedirect("index.jsp");
                break;
            case "view":
                response.sendRedirect("index.jsp");
                break;
        }
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaest");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int p1 = Integer.parseInt(request.getParameter("p1"));
        int p2 = Integer.parseInt(request.getParameter("p2"));
        int ef = Integer.parseInt(request.getParameter("ef"));
        
        
        Estudiante est1 = new Estudiante();
        
        est1.setId(id);
        est1.setNombre(nombre);
        est1.setP1(p1);
        est1.setP2(p2);
        est1.setEf(ef);

        
        int idt = est1.getId();
        
        if(idt == 0){
            int ultID;
            ultID = ultimoID(request);
            est1.setId(ultID);
            lista.add(est1);
        }
        else{
            lista.set(buscarIndice(request,idt), est1);
        }
        
        ses.setAttribute("listaest", lista);
        response.sendRedirect("index.jsp");
        
    }
    
    private int ultimoID(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        
        int idaux = 0;
        for (Estudiante item: lista){
            idaux = item.getId();
        }
        
        return idaux +1;
    }
    
    private int buscarIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");  
        int i=0;
        if(lista.size() > 0){
            while(i < lista.size()){
                if(lista.get(i).getId() == id){
                    break;
                }
                else{
                    i++;
                }
            }    
        }
        return i;
    }
}

    

    


