package kr.or.ddit.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.BookService;

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
		String result = bookService.create(map);
		
		if(result == "1") {
			return "redirect:/detail?bookId="+map.get("bookId");
		}
		return "book/createDetail";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(@RequestParam int bookId, Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("bookId", bookId);
		HashMap<String, Object> result = bookService.selectDetail(map);
		System.out.println("result : " + result);
		model.addAttribute("result", result);
		return "book/detail";
	}
	
}
