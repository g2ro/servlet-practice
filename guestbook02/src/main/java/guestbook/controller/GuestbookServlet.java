package guestbook.controller;

import java.io.IOException;
import java.util.List;

import guestbook.dao.GuestbookDao;
import guestbook.vo.GuestbookVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/gb")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		if("add".equals(action)) {
			String name = request.getParameter("name");	
			String password = request.getParameter("password");
			String contents = request.getParameter("contents");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);
			
//			System.out.println(vo)
			new GuestbookDao().insert(vo);
			
			response.sendRedirect("/guestbook02/gb");
			
		} else if("deleteform".equals(action)){
//			String id = request.getParameter("id");
//			request.setAttribute("id",  id);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		}else if("delete".equals(action)) {
			Long id = Long.parseLong(request.getParameter("id"));
			String password = request.getParameter("password");
			
			new GuestbookDao().deleteByIdAndPassword(id, password);
			
			response.sendRedirect("/guestbook02/gb");
			
		}else {
			// /gb, /gb?a=babo, ...예상 이외의 요청이 들어온 경우
			List<GuestbookVo> list = new GuestbookDao().findAll();
			request.setAttribute("list", list); // 이름, 객체로 매핑하여 jsp로 보내는 역
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response); // request가 연장됨 -> 설정한 jsp로 dispatch됨
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
