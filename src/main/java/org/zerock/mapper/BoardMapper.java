package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//Mapper 인터페이스를 작성할 때는 리스트와 등록 작업을 우선해서 작성함
	
	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
}
