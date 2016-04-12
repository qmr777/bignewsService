package qmr.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

import qmr.hotel.dao.Dao;
import qmr.hotel.model.User_info;
import qmr.hotel.util.JsonUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="/Login",urlPatterns="/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		User_info user_info = new User_info();
		//String username = "qmr777";
		//String password = "qmr777";
		user_info.setUsername(username);
		user_info.setPassword(password);
		user_info.setAuthority("1");
		Dao dao = new Dao();
		List<?> list = dao.select(user_info);
		PrintWriter out = response.getWriter();
		System.out.println(list.size());
		if(list.size()==1){
			//System.out.println(JsonUtil.createSingleJson("result", "登录成功"));
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("result","success");
			map.put("errcode", "0");
			//System.out.println(JsonUtil.createJson(map));
			out.print(JsonUtil.createJson(map));
		}
		else {
			//System.out.println(JsonUtil.createSingleJson("result", "登录成功"));
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("result","用户名/密码不存在");
			map.put("errcode", "1");
			out.print(JsonUtil.createJson(map));
		}
		out.flush();
		out.close();
	}

}
