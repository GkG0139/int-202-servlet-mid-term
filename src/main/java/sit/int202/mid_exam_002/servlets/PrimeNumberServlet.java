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
import sit.int202.mid_exam_002.constants.Common;
import sit.int202.mid_exam_002.utils.Utils;

@WebServlet(name = "PrimeNumberServlet", value = Common.DEFAULT_PATH
    + "is_prime")
public class PrimeNumberServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
      resp.sendRedirect("register");
      return;
    }

    req.getRequestDispatcher("/is_prime.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String numberString = req.getParameter("number");
    if (isInvalidInput(numberString)) {
      req.setAttribute("error", generateInvalidErrorMessage(numberString));
    } else {
      int number = Integer.parseInt(numberString);
      boolean isPrime = Utils.isPrimeNumber(number);

      int cookieSize = req.getCookies().length;
      Cookie cookie = new Cookie(Integer.toString(cookieSize), numberString);
      cookie.setMaxAge(60 * 60 * 24 * 365 * 10);

      resp.addCookie(cookie);
      req.setAttribute("success", generateIsPrimeMessage(isPrime, number));
    }
    req.getRequestDispatcher("/is_prime.jsp").forward(req, resp);
  }

  private boolean isInvalidInput(String str) {
    if (str == null || str.isEmpty() || !str.chars()
        .allMatch(Character::isDigit) || str.contains(".")) {
      return true;
    }
    return Integer.parseInt(str) < 2;
  }

  private String generateInvalidErrorMessage(String str) {
    return (str.isEmpty() ? "Empty" : str) + " is invalid input!";
  }

  private String generateIsPrimeMessage(boolean isPrime, int number) {
    return number + (isPrime ? " is prime number" : " is not prime number");
  }
}
