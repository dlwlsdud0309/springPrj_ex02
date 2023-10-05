package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
//	public List<BoardVO> getList();
	
	//페이징 처리는 브라우저에서 들어오는 정보들을 기준으로 동작
	//BoardController와 BoardService를 전달되는 파라미터들을 받는 형태로 수정해야한다
	public List<BoardVO> getList(Criteria cri);
}
