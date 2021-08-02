package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.BookService;
import kr.or.ddit.utils.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("message", "도서를 등록하세요.");
		return "book/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(@RequestParam HashMap<String, Object> map, Model model) {
		
		log.info("map : " + map);
		int result = bookService.create(map);
		if(result > 0) {
			return "redirect:/detail/"+map.get("bookId");
		}
		return "book/create";
	}
	
	@RequestMapping(value = "/detail/{bookId}")
	public String detail(@PathVariable("bookId") int bookId, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("bookId", bookId);
		Map<String, Object> result = bookService.selectDetail(map);
		model.addAttribute("result", result);
		log.info("detail");
		return "book/detail";
	}
	
	@RequestMapping(value = "/list")
	public String listPage(PagingVO vo, @RequestParam Map<String, Object> map, Model model) {
		
		int total = bookService.count(map);
		int nowPage = 1;
		int cntPerPage = 5;
		
		if(map.containsKey("nowPage")) {
			nowPage = Integer.valueOf((String)map.get("nowPage"));
		}
		if(map.containsKey("cntPerPage")) {
			cntPerPage = Integer.valueOf((String)map.get("cntPerPage"));
		}
		
		vo = new PagingVO(total, nowPage, cntPerPage);

		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		model.addAttribute("paging", vo);
		model.addAttribute("result", bookService.selectListPage(map));
		
		if(map.containsKey("keyword")) {
			model.addAttribute("keyword", map.get("keyword"));
		}
		
		return "book/listPaging";
	}
	
	@RequestMapping(value = "/edit/{bookId}", method = RequestMethod.GET)
	public String edit(@PathVariable("bookId") int bookId, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("bookId", bookId);
		Map<String, Object> result = bookService.selectDetail(map);
		model.addAttribute("result", result);
		return "book/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editSubmit(@RequestParam Map<String, Object> map, Model model) {
		int result = bookService.edit(map);
		return "redirect:/detail/" + map.get("bookId");
	}
	
}
