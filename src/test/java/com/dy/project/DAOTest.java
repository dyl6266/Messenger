//package com.penta.test;
//
//import java.util.HashMap;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.penta.common.domain.Authority;
//import com.penta.common.domain.Gender;
//import com.penta.common.domain.YesNo;
//import com.penta.dao.UserDAO;
//import com.penta.domain.CustomUserDetails;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
////@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/applicationContext-security.xml" })
//@ContextConfiguration(locations = { "classpath:/config/spring/context-*.xml" })
//public class DAOTest {
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Autowired
//	private UserDAO dao;
//	
//	@Test
////	@ResponseBody
//	public void test() {
//		HashMap<String, Object> params = new HashMap<>();
//		params.put("email", "dyl6266");
//		params.put("password", "12345678");
//		System.out.println(params);
//		
////		JsonObject json = new JsonObject();
////		json.addProperty("email", "dyl6266");
////		json.addProperty("password", "12345678");
////		System.out.println(json);
//	}
//
//	@Test
//	public void testInsert() {
//		for (int i = 2; i < 20; i++) {
//			CustomUserDetails user = new CustomUserDetails();
//			user.setEmail(i + "@@naver.com");
//			user.setPassword(passwordEncoder.encode("vpsxk2019"));
//			user.setName(i + "번 유저");
//			user.setPhone("0100000" + i);
//			user.setGender(Gender.F);
//			user.setAuthority(Authority.valueOf(2));
//			user.setStatus(YesNo.Y);
//			dao.insertUser(user);
//		}
//
//	}
//
//	@Test
//	public void testSelectObject() {
//		dao.selectUserDetail("dyl6266@@naver.com");
//	}
//
//	@Test
//	public void testUpdate() {
//		CustomUserDetails user = new CustomUserDetails();
//		user.setEmail("dyl6266@@naver.com");
//
//		user.setPassword(passwordEncoder.encode("vpsxkzhem123"));
//		user.setName("도영 123");
//		user.setPhone("01033242234");
//		user.setGender(Gender.M);
//		dao.updateUser(user);
//	}
//
//	@Test
//	public void testDelete() {
//		dao.deleteUser("dyl6266@naver.com");
//	}
//	
//	@Test
//	public void testCount() {
//		dao.selectTotalCount(null);
//	}
//	
//	@Test
//	public void testList() {
//		dao.selectUserList(null);
//	}
//
//}