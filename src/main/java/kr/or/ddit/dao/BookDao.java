package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return sqlSessionTemplate.insert("book.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("book.selectDetail", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return sqlSessionTemplate.selectList("book.selectList", map);
	}
	 
	public int count(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("book.count", map);
	}
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map){
		return sqlSessionTemplate.selectList("book.selectListPage", map);
	}
	
	public int edit(Map<String, Object> map) {
		return sqlSessionTemplate.update("book.update", map);
	}
}
