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
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmetic.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String submit = request.getParameter("submit");
        String result = "";
        int firstNum = 0;
        int secondNum = 0;
        int answer = 0;
        
        request.setAttribute("first", first);
        request.setAttribute("second", second);

        if (first == null || second == null || first.equals("") || second.equals("")) {
            result = "invalid";
            request.setAttribute("result", result);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmetic.jsp")
                    .forward(request, response);
            return;
        }

        Boolean areNumbers = true;

        try {
            firstNum = Integer.parseInt(first);
            secondNum = Integer.parseInt(second);

            if (submit.equals("+")) {
                answer = firstNum + secondNum;
            } else if (submit.equals("-")) {
                answer = firstNum - secondNum;
            } else if (submit.equals("*")) {
                answer = firstNum * secondNum;
            } else if (submit.equals("%")) {
                answer = firstNum%secondNum;
            }

        } catch (NumberFormatException e) {
            areNumbers = false;
        }

        if (areNumbers == false) {
            result = "invalid";
            request.setAttribute("result", result);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmetic.jsp")
                    .forward(request, response);
            return;
        }

        request.setAttribute("result", answer);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmetic.jsp")
                .forward(request, response);
    }
}
