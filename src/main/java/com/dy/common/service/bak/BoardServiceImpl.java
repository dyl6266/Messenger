//package com.dy.common.service.bak;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import com.dy.common.util.HttpUtils;
//import com.dy.dao.BoardDAO;
//import com.dy.domain.BoardVO;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//@Service("boardService")
//public class BoardServiceImpl implements BoardService {
//
//	/** BoardDAO */
//	@Autowired
//	private BoardDAO boardDAO;
//
//	/**
//	 * 게시글을 등록 또는 수정한다.
//	 * @param params - 등록 또는 수정할 정보가 담긴 VO
//	 * @return
//	 */
//	@Override
//	public boolean registerBoard(BoardVO params) {
//
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		/* params를 Json 형태로 변경하여 html & script 태그를 제거한 다음, 다시 오브젝트로 형태로 변환 */
//		String jsonParams = HttpUtils.stripTag(gson.toJson(params));
//		params = gson.fromJson(jsonParams, BoardVO.class);
//
//		/* insert, update 구분 */
//		int queryCnt = (params.getIdx() == null ? boardDAO.insertBoard(params) : boardDAO.updateBoard(params));
//		if (queryCnt != 1) {
//			return false;
//		}
//
//		return true;
//	}
//
//	/**
//	 * 게시글을 조회한다.
//	 * @param idx - 조회할 게시글 번호 (PK)
//	 * @return 게시글 상세 정보
//	 */
//	@Override
//	public BoardVO selectBoardDetails(Long idx) {
//		return boardDAO.selectBoardDetails(idx);
//	}
//
//	/**
//	 * 게시글을 Json 형태로 조회한다.
//	 * @param idx - 조회할 게시글 번호 (PK)
//	 * @return Json 형태의 게시글 상세 정보
//	 */
//	@Override
//	public String selectBoardDetailsByJson(Long idx) {
//
//		String jsonString = null;
//
//		BoardVO board = boardDAO.selectBoardDetails(idx);
//		if (ObjectUtils.isEmpty(board) == false) {
//			Gson gson = new GsonBuilder().create();
//			jsonString = gson.toJson(board);
//		}
//
//		return jsonString;
//	}
//
//	/**
//	 * 게시글을 삭제한다.
//	 * @param idxs - 삭제할 게시글 번호 리스트
//	 * @return 쿼리 실행 수
//	 */
//	@Override
//	public boolean deleteBoard(List<Long> idxs) {
//
//		int queryCnt = boardDAO.deleteBoard(idxs);
//		if (queryCnt < 1) {
//			return false;
//		}
//
//		return true;
//	}
//
//	/**
//	 * 게시글 리스트를 조회한다.
//	 * @param params - 조회할 정보가 담긴 VO (게시글 정보 & 페이징 정보)
//	 * @return 게시글 리스트
//	 */
//	@Override
//	public List<BoardVO> selectBoardList(BoardVO params) {
//
//		List<BoardVO> boardList = null;
//		int totalCnt = boardDAO.selectTotalCnt(params);
//		if (totalCnt > 0) {
//			boardList = boardDAO.selectBoardList(params);
//		}
//
//		return boardList;
//	}
//
//	/**
//	 * 게시글 리스트를 Json 형태로 조회한다.
//	 * @param params - 조회할 정보가 담긴 VO (게시글 정보 & 페이징 정보)
//	 * @return Json 형태의 게시글 리스트
//	 */
//	@Override
//	public String selectBoardListByJson(BoardVO params) {
//
//		String jsonString = null;
//
//		int totalCnt = boardDAO.selectTotalCnt(params);
//		if (totalCnt > 0) {
//			List<BoardVO> boardList = boardDAO.selectBoardList(params);
//
//			if (ObjectUtils.isEmpty(boardList) == false) {
//				Gson gson = new GsonBuilder().create();
//				jsonString = gson.toJson(boardList);
//			}
//		}
//
//		return jsonString;
//	}
//
//}
