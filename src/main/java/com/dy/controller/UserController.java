package com.dy.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dy.common.domain.Result;
import com.dy.common.service.CommonService;
import com.dy.domain.CustomUserDetails;
import com.dy.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/* Rest 방식을 이용하기 위한 컨트롤러 (@ResponseBody 애너테이션을 생략할 수 있음) */
@RestController
public class UserController {

	@Autowired
	private CommonService commonService;

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 사용자의 이메일로 회원가입 인증번호 전송
	 * 
	 * TODO : ModelAttribute 애너테이션을 사용하면 form 데이터를 받을 수 있음
	 * 
	 * @param params - VO 인스턴스
	 * @return ResponseEntity - (데이터, 상태 코드)
	 */
	@RequestMapping(value = "/users/mails", method = RequestMethod.POST)
	public ResponseEntity<JsonObject> sendAuthKeyByUserMail(@RequestBody CustomUserDetails params) {

		/* 실패 처리에 대한 결과 JSON */
		JsonObject json = new JsonObject();
		json.addProperty("result", Result.FAIL.toString());
		json.addProperty("message", "오류가 발생했습니다. 다시 시도해 주세요.");

		if (ObjectUtils.isEmpty(params) == true || StringUtils.isEmpty(params.getEmail()) == true) {
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}

		try {
			/* 아이디 중복 체크 */
			CustomUserDetails userDetails = userService.selectUserDetail(params.getEmail());
			if (ObjectUtils.isEmpty(userDetails) == false) {
				json = new JsonObject();
				json.addProperty("result", Result.FAIL.toString());
				json.addProperty("message", "이미 가입된 계정입니다.");
				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
			}

			/* 인증키 저장 & 이메일 전송 */
			boolean status = commonService.registerAuthKeyAndSendMail(params.getEmail());
			if (status == false) {
				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
			} else {
				json = new JsonObject();
				json.addProperty("result", Result.SUCCESS.toString());
				json.addProperty("message", "메일로 발송된 인증번호를 입력해 주세요.");
				return new ResponseEntity<>(json, HttpStatus.OK);
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}
	}
	// end of method

	/**
	 * 인증번호 유효성 체크 & 회원 등록
	 * 
	 * @param params - VO 인스턴스
	 * @return ResponseEntity - (데이터, 상태 코드)
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<JsonObject> checkAuthKeyAndRegister(@RequestBody CustomUserDetails params) {

		/* 실패 처리에 대한 결과 JSON */
		JsonObject json = new JsonObject();
		json.addProperty("result", Result.FAIL.toString());
		json.addProperty("message", "오류가 발생했습니다. 다시 시도해 주세요.");

		if (ObjectUtils.isEmpty(params) == true) {
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}

		try {
			/* 인증번호 유효성 확인 */
			boolean status = commonService.checkAuthKeyValidation(params.getKey(), params.getEmail());
			if (status == false) {
				json = new JsonObject();
				json.addProperty("result", Result.FAIL.toString());
				json.addProperty("message", "유효하지 않은 인증번호입니다. 다시 시도해 주세요.");
				return new ResponseEntity<JsonObject>(json, HttpStatus.OK);
			}

			status = userService.registerUser(params);
			if (status == false) {
				return new ResponseEntity<JsonObject>(json, HttpStatus.BAD_REQUEST);
			} else {
				json = new JsonObject();
				json.addProperty("result", Result.SUCCESS.toString());
				json.addProperty("message", "회원가입이 완료되었습니다!");
				return new ResponseEntity<JsonObject>(json, HttpStatus.OK);
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}

	}
	// end of method

	@RequestMapping(value = "/users/{email:.+}")
	public ResponseEntity<JsonObject> getUserDetailInfomation(@PathVariable("email") String email) {
		
		/* 실패 처리에 대한 결과 JSON */
		JsonObject json = new JsonObject();
		json.addProperty("result", Result.FAIL.toString());
		json.addProperty("message", "오류가 발생했습니다. 다시 시도해 주세요.");
		
		if ( StringUtils.isEmpty(email) == true ) {
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}

		CustomUserDetails userDetails = userService.selectUserDetail(email);
		if ( ObjectUtils.isEmpty(userDetails) == true ) {
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		} else {
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jsonStr = gson.toJson(userDetails);
			json = new JsonObject();
			json.addProperty("result", Result.SUCCESS.toString());
			json.addProperty("userDetails", jsonStr);

			return new ResponseEntity<>(json, HttpStatus.OK);
		}

	}
	// end of method
	
	@RequestMapping(value = "/member/accessDenied.do")
	public String openAccessDeniedPage() {

		return "/member/accessDenied";
	}

}
