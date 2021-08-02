package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	
	public int create(Map<String, Object> map);
	
	public Map<String, Object> selectDetail(Map<String, Object> map);
	
	public List<Map<String, Object>> selectList(Map<String, Object> map);
	
	public int count(Map<String, Object> map);
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map);

	public int edit(Map<String, Object> map);
}
