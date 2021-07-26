package kr.or.ddit.service;

import java.util.HashMap;

public interface BookService {
	
	public String create(HashMap<String, Object> map);
	
	public HashMap<String, Object> selectDetail(HashMap<String, Object> map);
}
