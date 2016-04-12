package qmr.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qmr.hotel.dao.Dao;
import qmr.hotel.model.Food_info;
import qmr.hotel.model.Room_info;
import qmr.hotel.util.JsonUtil;

/**
 * Servlet implementation class RoomType
 */
@WebServlet(name = "/RoomType",urlPatterns = "/RoomType")
public class RoomType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomType() {
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
		//HashMap<String, String> dataMap = new HashMap<String, String>();
		Dao dao = new Dao();
		Field[] fields = Room_info.class.getDeclaredFields();
		for(Field f:fields){
			System.out.println(f.getName());
		}
		List<?> list = dao.select(new Room_info());
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String,String>>();
		
		for(int i = 0;i<list.size();i++){
			HashMap<String, String> map = new HashMap<String, String>();
			for(Field f:fields){
				try {
					map.put(f.getName(), (String) f.get(list.get(i)));
				} catch (IllegalArgumentException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}//end for(fields)
			dataList.add(map);
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "查询成功");
		map.put("errcode", "0");
		String returnString = JsonUtil.createMultiJson(map, dataList);
		PrintWriter out = response.getWriter();
		out.print(returnString);
		out.flush();
		out.close();
	}
	
}
