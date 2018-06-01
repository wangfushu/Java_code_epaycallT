package gmms.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gmms.domain.db.Employee;
import gmms.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class CurrentUserInterceptor extends HandlerInterceptorAdapter {
	private static Logger LOGGER = LoggerFactory.getLogger(CurrentUserInterceptor.class);
	@Autowired
	private EmployeeService employeeService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		getCurrentUser(request);
		return super.preHandle(request, response, handler);
	}

	private void getCurrentUser(HttpServletRequest request) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("currentUser");
		if (employee == null || employee.geteId() == null) {
			if (SecurityContextHolder.getContext() != null
					&& SecurityContextHolder.getContext().getAuthentication() != null
					&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
					&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal();
				if (userDetails != null) {
					String username = userDetails.getUsername();
					employee = employeeService.findByName(username);
					/*if (CollectionUtils.isNotEmpty(employee.getRoles())) {
						List<String> roleStr = Lists.newArrayList();
						for (Role role : users.getRoles()) {
							roleStr.add(role.getName());
						}
						request.getSession().setAttribute("currentRole", roleStr);
					}*/
					request.getSession().setAttribute("currentUser", employee);

				}
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
