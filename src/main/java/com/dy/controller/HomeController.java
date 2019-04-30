package com.dy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {

	@Autowired
	private ServletContext servletContext;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("/test")
	public String test(HttpServletRequest request, HttpSession session) throws IOException {

		List<String> testList = new ArrayList<>();
		testList.add("base");
		testList.add("gallery");
		testList.add("qna");
		testList.add("notify");
		testList.add("faq");
		testList.add("contents_data");
		testList.add("movie");
		testList.add("board_galley");
		testList.add("newsletter");

		for (String filename : testList) {
			String jspName = "/WEB-INF/views/board/" + filename + ".jsp";

			System.out.println(jspName);
			URL url = servletContext.getResource(jspName);
		}

		return "";

	}
	//	@GetMapping("/test")
	//	public String test(HttpServletRequest request, HttpSession session) {
	//		
	//		List<String> testList = new ArrayList<>();
	//		testList.add("base");
	//		testList.add("gallery");
	//		testList.add("qna");
	//		testList.add("notify");
	//		testList.add("faq");
	//		testList.add("contents_data");
	//		testList.add("movie");
	//		testList.add("board_galley");
	//		testList.add("newsletter");
	//		
	////		for ( String str : testList ) {
	////			
	////		}
	//		
	//		Set<String> pathSet = request.getSession().getServletContext().getResourcePaths("/");
	//		System.out.println(pathSet);
	//		
	//		String jspPath = request.getSession().getServletContext().getRealPath("/resources/test.jsp");
	//		System.out.println(jspPath);
	//		
	//		if ( StringUtils.isEmpty(jspPath) == false ) {
	//			File file = new File(jspPath);
	//			System.out.println(file.exists());
	//		}
	//		return "";
	//		
	//	}

}
