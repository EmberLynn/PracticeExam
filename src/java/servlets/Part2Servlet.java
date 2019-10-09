/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Person;

/**
 *
 * @author 738634
 */
public class Part2Servlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String setphrase =(String)session.getAttribute("set");
        double age = 0;
        int count = 0;
        request.setAttribute("motivation", setphrase);
        
        String path = getServletContext().getRealPath("/WEB-INF/list.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String line;
            while((line = br.readLine()) != null)
            {
                String [] section = line.split(",");
                Person person = new Person(section[0],Integer.parseInt(section[1]));
                age += person.getAge();
                count++;
            }
        double average = age/count;    
        request.setAttribute("average", average);
        
        String err = request.getParameter("message");
        request.setAttribute("error", err);
        
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Person person;
        
        if(name == null || name.equals("") 
                 || age == null || age.equals(""))
         {
             response.sendRedirect("part2");
             return;
         }
        
        try
        {
            if(Integer.parseInt(age) < 0)
            {
                throw new NumberFormatException();
            }
            person = new Person(name, Integer.parseInt(age));
        }catch(NumberFormatException e)
        {
            response.sendRedirect("part2?message=Must%20enter%20a%20positive%20number.");
            return;
        }
        
        
        String path = getServletContext().getRealPath("/WEB-INF/list.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); 
        
        pw.write("\n"+person.getName()+","+person.getAge());
        pw.close();
        response.sendRedirect("part2");
        
    }


}
