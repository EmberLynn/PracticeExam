
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 738634
 */
public class Part1Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String phrase = (String)session.getAttribute("set");
        
        if(phrase != null)
        {
            response.sendRedirect("part2");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
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
        
        HttpSession session = request.getSession();
        String setphrase = (String)session.getAttribute("set");
        String phrase = request.getParameter("phrase");
        
        if(phrase == null||phrase.equals(""))
          {
            request.setAttribute("motivation", setphrase);
          }
        else
        {
            session.setAttribute("set", phrase);
            setphrase =(String)session.getAttribute("set");
            request.setAttribute("motivation", setphrase);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
    }


}
