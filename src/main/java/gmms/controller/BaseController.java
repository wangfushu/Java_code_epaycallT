package gmms.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;

import gmms.domain.db.Employee;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseController {
    @Autowired
    protected Validator validator;
    @Autowired
    protected HttpSession session;
    @Autowired
    protected HttpServletRequest request;

    protected String getCurrentPath() {
        return (String) request.getAttribute("absoluteContextPath");
    }


    public Employee getCurrentUser() {
        return (Employee) session.getAttribute("currentUser");
    }


    private void add2CookieIfNotNull(HttpServletResponse httpServletResponse, String name, Object value) {
        if (value == null) {
            value = "";
        }
        Cookie cookie = new Cookie(name, value.toString());
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }
}
