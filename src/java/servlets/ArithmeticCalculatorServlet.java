package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 799768
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmetic.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String submit = request.getParameter("submit");

        if (first == null || second == null || first.equals("") || second.equals("")) {
            request.setAttribute("result", "invalid");
        } else if (submit.equals("+")) {
            request.setAttribute("result", Integer.parseInt(first) + Integer.parseInt(second));
        } else if (submit.equals("-")) {
            request.setAttribute("result", Integer.parseInt(first) - Integer.parseInt(second));
        } else if (submit.equals("*")) {
            request.setAttribute("result", Integer.parseInt(first) * Integer.parseInt(second));
        } else {
            request.setAttribute("result", Integer.parseInt(first) % Integer.parseInt(second));
        }
        getServletContext().getRequestDispatcher("/WEB-INF/arithmetic.jsp")
                    .forward(request, response);
    }
}
