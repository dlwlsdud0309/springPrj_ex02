package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//Mapper 인터페이스를 작성할 때는 리스트와 등록 작업을 우선해서 작성함
	
//	@Select("select * from tbl_board where bno > 0")  //XML에 SQL문을 작성하였으니 주석처리
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
}
