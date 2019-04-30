package com.dy.common.service.bak;

import java.util.List;

import com.dy.domain.BoardVO;

public interface BoardService {

	/**
	 * 게시글을 등록 또는 수정한다.
	 * @param params - 등록 또는 수정할 정보가 담긴 VO
	 * @return
	 */
	public boolean registerBoard(BoardVO params);

	/**
	 * 게시글을 조회한다.
	 * @param idx - 조회할 게시글 번호 (PK)
	 * @return 게시글 상세 정보
	 */
	public BoardVO selectBoardDetails(Long idx);

	/**
	 * 게시글을 Json 형태로 조회한다.
	 * @param idx - 조회할 게시글 번호 (PK)
	 * @return Json 형태의 게시글 상세 정보
	 */
	public String selectBoardDetailsByJson(Long idx);

	/**
	 * 게시글을 삭제한다.
	 * @param idxs - 삭제할 게시글 번호 리스트
	 * @return 쿼리 실행 수
	 */
	public boolean deleteBoard(List<Long> idxs);

	/**
	 * 게시글 리스트를 조회한다.
	 * @param params - 조회할 정보가 담긴 VO (게시글 정보 & 페이징 정보)
	 * @return 게시글 리스트
	 */
	public List<BoardVO> selectBoardList(BoardVO params);

	/**
	 * 게시글 리스트를 Json 형태로 조회한다.
	 * @param params - 조회할 정보가 담긴 VO (게시글 정보 & 페이징 정보)
	 * @return Json 형태의 게시글 리스트
	 */
	public String selectBoardListByJson(BoardVO params);

}
