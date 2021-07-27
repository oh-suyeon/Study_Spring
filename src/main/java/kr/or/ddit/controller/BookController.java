package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.BookService;
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
		String result = bookService.create(map);
		if(result == "1") {
			return "redirect:/detail/"+map.get("bookId");
		}
		return "book/create";
	}
	
	@RequestMapping(value = "/detail/{bookId}")
	public String detail(@PathVariable("bookId") int bookId, Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("bookId", bookId);
		HashMap<String, Object> result = bookService.selectDetail(map);
		model.addAttribute("result", result);
		
		log.info("detail");
		
		return "book/detail";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<HashMap<String, Object>> result = 
				bookService.selectList(new HashMap<String, Object>());
		model.addAttribute("result",result);
		return "book/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String listSearch(@RequestParam HashMap<String, Object> map, Model model) {
		List<HashMap<String, Object>> result = 
				bookService.selectList(map);
		model.addAttribute("result",result);
		return "book/list";
	}
	
	@RequestMapping(value = "/edit/{bookId}", method = RequestMethod.GET)
	public String edit(@PathVariable("bookId") int bookId
					  , Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("bookId", bookId);
		HashMap<String, Object> result = bookService.selectDetail(map);
		model.addAttribute("result", result);
		return "book/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editSubmit(@RequestParam HashMap<String, Object> map
							, Model model) {
		int result = bookService.edit(map);
		return "redirect:/detail/" + map.get("bookId");
	}
	
}
