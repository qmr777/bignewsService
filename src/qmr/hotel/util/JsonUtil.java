package qmr.hotel.util;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

public class JsonUtil {
	
	public static String createJson(HashMap<String, String> map){
		JSONObject jsonObject = new JSONObject();
		for(String key:map.keySet()){
			jsonObject.put(key, map.get(key));
		}
		return jsonObject.toString();
	}
	
	public static String createSingleJson (String key,String value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();		
	}
	
	public static String createMultiJson(HashMap<String, String> msg,List<HashMap<String, String>> dataList) {
		//String dataJsonString = "["+createJson(data)+"]";
		String dataJsonString = "[";
		for(HashMap<String, String> dataMap : dataList ){
			dataJsonString+=createJson(dataMap)+",";
		}
		dataJsonString+="]";
		msg.put("retData", dataJsonString);
		
		return createJson(msg).toString();
	}
	
/*	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		HashMap<String,String> map1 = new HashMap<String, String>();
		HashMap<String,String> map2 = new HashMap<String, String>();
		HashMap<String,String> map3 = new HashMap<String, String>();
		map.put("result","账号已存在!");
		map1.put("errcode", "1");
		map2.put("errcode2", "1");
		map3.put("errcode3", "1");
		List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		System.out.println(createMultiJson(map,list).toString());
	}*/
	
}
