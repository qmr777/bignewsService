package qmr.hotel.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qmr.hotel.dao.Dao;
import qmr.hotel.model.Order_info;

import com.google.gson.Gson;

/**
 * Servlet implementation class BookHotel
 */
@WebServlet(name = "/BookHotel",urlPatterns = "/BookHotel")
public class BookHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookHotel() {
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
/*		PrintWriter out = response.getWriter();
		out.print("hello");
		out.flush();
		out.close();*/
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("BookHotel");
		InputStream is = request.getInputStream();
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		while((line = reader.readLine())!=null){
			buffer.append(line);
		}
		is.close();
		Order_info model = null;
		boolean flag = true;
		try {
			Gson gson = new Gson();
			model = gson.fromJson(buffer.toString(), Order_info.class);
			new Dao().insert(model);
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		if(flag){
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		}
		String data = buffer.toString();
		System.out.printf(data);
	}

}
