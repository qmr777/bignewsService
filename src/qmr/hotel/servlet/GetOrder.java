package qmr.hotel.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.core.annotation.Order;

import qmr.hotel.dao.Dao;
import qmr.hotel.model.Order_info;
import qmr.hotel.util.JsonUtil;

/**
 * Servlet implementation class GetOrder
 */
@WebServlet("/GetOrder")
public class GetOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrder() {
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
		Order_info order_info = new Order_info();
		Scanner scanner = new Scanner(request.getInputStream());
		String username = scanner.next();
		order_info.setUser_name(username);
		
		System.out.println(username);
		InputStream is = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		//order_info.setUser_name(reader.readLine());
		reader.close();
		is.close();
		List<?> list = new Dao().select(order_info);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("errcode", "0");
		map.put("result", "success");
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		if(list.size()!=0){
			Field[] fields = list.get(0).getClass().getDeclaredFields();
			for(Object object:list){
				HashMap<String, String> hashMap = new HashMap<String, String>();
				for(Field field : fields){
					try {
						hashMap.put(field.getName(),(String)field.get(object));
					} catch (IllegalArgumentException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				dataList.add(hashMap);
			}
		}
		String json = JsonUtil.createMultiJson(map, dataList);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
	}

}
