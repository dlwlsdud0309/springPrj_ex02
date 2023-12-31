package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor //생성자를 만들지 않을 경우 @Setter(onMethod_={@Autowired}) 이용하여 처리
public class BoardController { //BoardController는 BoardService에 대해서 의존적이다

	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list");
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: "+cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123)); //123은 임의의 값
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : "+board);
		
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
//	@GetMapping("/get")
	@GetMapping({"/get", "modify"})
//	public void get(@RequestParam("bno") Long bno, Model model) {
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("modify : "+board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	//삭제처리는 반드시 Post방식으로
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..."+bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	//보여주는 역할만 함
	@GetMapping("/register")
	public void register() {
		
	}
}
