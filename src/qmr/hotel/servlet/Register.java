package qmr.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import qmr.hotel.dao.Dao;
import qmr.hotel.model.User_info;
import qmr.hotel.util.JsonUtil;

/**
 * Servlet implementation class Register
 */
@WebServlet(name="/Register",urlPatterns="/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		User_info user_info = new User_info();
		System.out.println("register");
		user_info.setAuthority("1");
		user_info.setUsername(request.getParameter("username"));
		user_info.setPassword(request.getParameter("password"));
		user_info.setPhonenum(request.getParameter("phonenum"));
		user_info.setIdnum(request.getParameter("idnum"));
		Dao dao = new Dao();
		PrintWriter outPrintWriter = response.getWriter();
		if(dao.insert(user_info)){
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("result","注册成功");
			map.put("errcode", "0");
			outPrintWriter.print(JsonUtil.createJson(map));
		}
		else {
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("result","账号已存在!");
			map.put("errcode", "1");
			outPrintWriter.print(JsonUtil.createJson(map));
		}
		outPrintWriter.flush();
		outPrintWriter.close();
	}
}
