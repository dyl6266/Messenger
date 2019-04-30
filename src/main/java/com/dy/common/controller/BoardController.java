//package com.dy.common.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dy.common.Constant.Result;
//import com.dy.common.util.JsonUtils;
//import com.dy.domain.BoardVO;
//import com.dy.service.BoardService;
//import com.google.gson.JsonObject;
//
///* TODO => CrossOrigin 애너테이션 알아보기 */
//@RestController
//public class BoardController {
//
//	/** BoardService */
//	@Autowired
//	private BoardService boardService;
//
//	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
//
//	/**
//	 * 게시글을 등록한다.
//	 * @param params - 등록할 정보가 담긴 VO
//	 * @param bindingResult - VO 검증 결과가 담긴 인스턴스
//	 * @return Json
//	 */
//	@PostMapping(value = "/boards", produces = "application/json")
//	public ResponseEntity<JsonObject> registerBoard(@RequestBody @Valid final BoardVO params, BindingResult bindingResult) { // BindingResult 대신 Errors 객체를 사용해도 됨
//
//		JsonObject json = new JsonObject();
//
//		/* VO 유효성 검증에 실패했을 경우 */
//		if (bindingResult.hasErrors()) {
//			FieldError fieldError = bindingResult.getFieldError();
//
//			json.addProperty("result", Result.FAIL.toString());
//			json.addProperty("message", fieldError.getDefaultMessage());
//			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		try {
//			/* 등록 서비스 호출 */
//			boolean isSuccessed = boardService.registerBoard(params);
//			if (isSuccessed == false) {
//				json = JsonUtils.getResultAndMessage(Result.FAIL);
//				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//			}
//
//		} catch (DataAccessException e) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
//
//		} catch (Exception e) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		json = JsonUtils.getResultAndMessage(Result.OK);
//		return new ResponseEntity<>(json, HttpStatus.OK);
//	}
//
//	/**
//	 * 게시글을 수정한다.
//	 * @param idx - 수정할 게시글 번호
//	 * @param params - 수정할 정보가 담긴 VO
//	 * @param bindingResult - VO 검증 결과가 담긴 인스턴스
//	 * @return Json
//	 */
//	@RequestMapping(value = "/boards/{idx}", method = { RequestMethod.PUT, RequestMethod.PATCH }, produces = "application/json")
//	public ResponseEntity<JsonObject> registerBoard(@PathVariable("idx") Long idx, @RequestBody @Valid final BoardVO params, BindingResult bindingResult) {
//
//		JsonObject json = new JsonObject();
//
//		/* VO 유효성 검증에 실패했을 경우 */
//		if (bindingResult.hasErrors()) {
//			FieldError fieldError = bindingResult.getFieldError();
//
//			json.addProperty("result", Result.FAIL.toString());
//			json.addProperty("message", fieldError.getDefaultMessage());
//			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		try {
//			/* TODO => PathVariable 애너테이션으로 인해서 VO 검증을 못하는 부분 어떻게 해야할지.. */
//			params.setIdx(idx);
//
//			/* 등록 서비스 호출 */
//			boolean isSuccessed = boardService.registerBoard(params);
//			if (isSuccessed == false) {
//				json = JsonUtils.getResultAndMessage(Result.FAIL);
//				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//			}
//
//		} catch (DataAccessException e) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
//
//		} catch (Exception e) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		json = JsonUtils.getResultAndMessage(Result.OK);
//		return new ResponseEntity<>(json, HttpStatus.OK);
//	}
//
//	/**
//	 * 게시글을 조회한다.
//	 * @param idx - 조회할 게시글 번호 (PK)
//	 * @return Json
//	 */
//	@GetMapping(value = "/boards/{idx}", produces = "application/json")
//	public ResponseEntity<JsonObject> selectBoardDetails(@PathVariable("idx") Long idx) {
//
//		JsonObject json = new JsonObject();
//
//		if (idx < 1) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<JsonObject>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		String jsonDetails = boardService.selectBoardDetailsByJson(idx);
//		if (StringUtils.isEmpty(jsonDetails)) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<JsonObject>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		json.addProperty("board", jsonDetails);
//		return new ResponseEntity<>(json, HttpStatus.OK);
//	}
//
//	/**
//	 * 게시글을 삭제한다.
//	 * @param idxs - 삭제할 게시글 번호 리스트
//	 * @return Json
//	 */
//	@DeleteMapping(value = "/boards/{idxs}", produces = "application/json")
//	public ResponseEntity<JsonObject> deleteBoard(@PathVariable("idxs") List<Long> idxs) {
//
//		JsonObject json = new JsonObject();
//
//		if (ObjectUtils.isEmpty(idxs)) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		try {
//			/* 삭제 서비스 호출 */
//			boolean isSuccessed = boardService.deleteBoard(idxs);
//			if (isSuccessed == false) {
//				json = JsonUtils.getResultAndMessage(Result.FAIL);
//				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//			}
//
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		json = JsonUtils.getResultAndMessage(Result.OK);
//		return new ResponseEntity<>(json, HttpStatus.OK);
//	}
//
//	/**
//	 * 게시글 리스트를 조회한다.
//	 * @param params - 조회할 정보가 담긴 VO (게시글 정보 & 페이징 정보)
//	 * @return Json
//	 */
//	@GetMapping(value = "/boards", produces = "application/json")
//	public ResponseEntity<JsonObject> selectBoardList(@ModelAttribute("params") BoardVO params) {
//
//		JsonObject json = new JsonObject();
//
//		if (ObjectUtils.isEmpty(params)) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		String jsonList = boardService.selectBoardListByJson(params);
//		if (StringUtils.isEmpty(jsonList)) {
//			json = JsonUtils.getResultAndMessage(Result.FAIL);
//			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
//		}
//
//		json.addProperty("boardList", jsonList);
//		return new ResponseEntity<>(json, HttpStatus.OK);
//	}
//
//}
