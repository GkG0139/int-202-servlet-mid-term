/**
 * Made by 65130500002 Koranat Ruedeejaroen
 */
package sit.int202.mid_exam_002.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import sit.int202.mid_exam_002.constants.Common;
import sit.int202.mid_exam_002.models.User;

@WebServlet(name = "RegisterServlet", value = Common.DEFAULT_PATH
    + "register")
public class RegisterServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/register_form.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String username = req.getParameter("username");
    String email = req.getParameter("email");

    HttpSession session = req.getSession(false);
    if (!(session == null || session.getAttribute("user") == null)) {
      session.invalidate();
    }
    session = req.getSession();
    User user = new User(username, email);
    session.setAttribute("user", user);
    resp.sendRedirect("is_prime");
  }
}

