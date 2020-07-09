package basicInformation.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basicInformation.dao.UnitDao;
import basicInformation.entity.Unit;

/**
 * Servlet implementation class UnitServlet
 */
@WebServlet("/UnitServlet")
public class UnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		UnitDao udao = new UnitDao();
		
		if("delete".equals(action)) {
			String unitCode = request.getParameter("unitCode");
			int dflag = 0;
			try {
				dflag = udao.deleteUnit(unitCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dflag==0) {
				out.write("É¾³ýÊ§°Ü");
			}
			
		} else if("update".equals(action)) {
			String unitCode = request.getParameter("unitCode");
			request.setAttribute("unitCode", unitCode);
			request.getRequestDispatcher("/basicInfo/updateUnit.jsp").forward(request, response);
			
		} else if("add".equals(action)) {
			
		}
		
		List<Unit> unitList = new ArrayList<Unit>();
		try {
			unitList = udao.showUnit();
		} catch (Exception e) {
			System.out.println("²éÑ¯Ê§°Ü");
			e.printStackTrace();
		}
		//request.setAttribute("unitList", unitList);
		HttpSession session = request.getSession();
		session.setAttribute("unitList", unitList);
		request.getRequestDispatcher("/basicInfo/unit.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
