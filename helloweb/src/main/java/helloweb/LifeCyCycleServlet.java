package helloweb;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lc")
public class LifeCyCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// servlet이 실행 되면 init이 가장 먼저 실행 
	public void init() throws ServletException {
		System.out.println("init() called");
		super.init();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service() called");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() called");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doPost() called");
	}

	public void destroy() {
		System.out.println("destory() called");
	}
}
