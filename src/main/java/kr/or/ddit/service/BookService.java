package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;

public interface BookService {
	
	public String create(HashMap<String, Object> map);
	
	public HashMap<String, Object> selectDetail(HashMap<String, Object> map);
	
	public List<HashMap<String, Object>> selectList(HashMap<String, Object> map);
	
	public int edit(HashMap<String, Object> map);
}
