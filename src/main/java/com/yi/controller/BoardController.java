package com.yi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.domain.PageDTO;
import com.yi.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*") //board �ؿ� list
@AllArgsConstructor

public class BoardController {

	private BoardService service;

	@GetMapping("/register")
	public void register() {

	}

//	 @GetMapping("/list")
//	 public void list(Model model) {
//	
//	 log.info("list"); //���� ���� �� 
//	 model.addAttribute("list", service.getList()); //�߿���.
//	
//	 }

//	 @GetMapping("/list") // �������� �Ѿ.
//	 public void list(Criteria cri, Model model) {  
//	
//	 log.info("list: " + cri);
//	 model.addAttribute("list", service.getList(cri));
//	
//	 }

	@GetMapping("/list")
	public void list(@ModelAttribute("criteria")Criteria cri, Model model) {

		log.info("list: " + cri);
		
	//	List<BoardVO> boardList = service.getList(cri);
		model.addAttribute("list", service.getList(cri));
		int total = service.getTotal(cri);
		log.info("total: " + total);

		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}

	@PostMapping("/register") //���
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", board.getName());

		return "redirect:/board/list";
	}


	@GetMapping({ "/get", "/modify" }) // ���� �̸��� �����ͼ� ���� �̸� �� ������.
	public void get(@RequestParam("mid") String mid,
			@ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(mid));
	}


	@PostMapping("/modify") //board�� ������ ��� �� ����.
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

		rttr.addAttribute("currentPageNo", cri.getCurrentPageNo());
		rttr.addAttribute("recordsPerPage", cri.getRecordsPerPage());

		return "redirect:/board/list";
	}


	@PostMapping("/remove")
	public String remove(@RequestParam("mid") int mid, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + mid);
		if (service.remove(mid)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("currentPageNo", cri.getCurrentPageNo());
		rttr.addAttribute("recordsPerPage", cri.getRecordsPerPage());

		return "redirect:/board/list";
	}

}
