/**
 * Made by 65130500002 Koranat Ruedeejaroen
 */
package sit.int202.mid_exam_002.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sit.int202.mid_exam_002.constants.Common;
import sit.int202.mid_exam_002.utils.Utils;
import sit.int202.mid_exam_002.viewModels.HistoryViewModel;

@WebServlet(name = "HistoryServlet", value = Common.DEFAULT_PATH + "history")
public class HistoryServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
      resp.sendRedirect("register");
      return;
    }

    Cookie[] cookies = req.getCookies();
    List<HistoryViewModel> history = new ArrayList<>();
    for (Cookie cookie : cookies) {
      if (cookie.getValue().chars().allMatch(Character::isDigit)) {
        int number = Integer.parseInt(cookie.getValue());
        history.add(new HistoryViewModel(number, Utils.isPrimeNumber(number)));
      }
    }

    req.setAttribute("history", history);
    req.getRequestDispatcher("/history.jsp").forward(req, resp);
  }
}
