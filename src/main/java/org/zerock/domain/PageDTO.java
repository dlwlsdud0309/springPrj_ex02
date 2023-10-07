package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	// 페이징 처리할 떄 필요한 정보들
	// 1.현제 페이지 번호(page)
	// 2.이전과 다음으로 이동 가능한 링크의 표시 여부(prev, next)
	// 3. 화면에서 보여지는 페이지의 시작 번호와 끝 번호(startPage, endPage)
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total; //전페 데이터 수
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10; //pageNum : 현제 페이지 번호
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount())); //amount : 페이지에서 보여주는 데이터 수
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
