/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 799768
 */
@WebServlet(name = "AgeCalculatorServlet", urlPatterns = {"/AgeCalculator"})
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String age = request.getParameter("age");
        int ageNum = 0;
        request.setAttribute("age", age);
        String message = new String();

        if (age == null || age.equals("")) {
            message = "You must give your current age";
        } else {
            try {
                ageNum = Integer.parseInt(age);
                int nextBirthday = ageNum + 1;
                message = "Your age next birthday will be " + nextBirthday;
            } catch (Exception e) {
                message = "You must enter a number";
            }
        }

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }
}
