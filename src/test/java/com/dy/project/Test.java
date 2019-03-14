//package com.penta.test;
//
//import java.util.HashMap;
//import java.util.Iterator;
//
//public class Test {
//
//	public static void main(String[] args) {
//
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("name", "도영");
//		map.put("age", "26");
//		map.put("gender", "mail");
//
//		Iterator<String> iterator = map.keySet().iterator();
//		while (iterator.hasNext()) {
//			String key = iterator.next();
//			String val = (String) map.get(key);
//			System.out.println(String.format("key : %s, 값 : %s", key, map.get(key)));
//		}
//
////		Gson gson = new Gson();
////		JsonObject json = new JsonObject();
////
////		String jsonStr = "{ \"userId\" : \"dyl6266@naver.com\" }";
////		JsonParser parser = new JsonParser();
////		JsonElement element = parser.parse(jsonStr);
////
////		String test2 = element.getAsJsonObject().get("userId").getAsString();
////		System.out.println(test2);
//
////		
////		String str = "{\"name\" : \"doyoung\", \"gender\" : \"F\", \"phone\" : \"01033282436\" }";
////		CustomUserDetails user = gson.fromJson(str, CustomUserDetails.class);
//	}
//
//}
