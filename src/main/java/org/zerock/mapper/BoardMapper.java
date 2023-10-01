package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	//Mapper 인터페이스를 작성할 때는 리스트와 등록 작업을 우선해서 작성함
	
//	@Select("select * from tbl_board where bno > 0")  //XML에 SQL문을 작성하였으니 주석처리
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri); //Criteria 타입을 파라미터로 사용하는 getListWithPaging() 메서드
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
