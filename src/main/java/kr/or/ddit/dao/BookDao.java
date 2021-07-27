package kr.or.ddit.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(HashMap<String, Object> map) {
		return sqlSessionTemplate.insert("book.insert", map);
	}
	
	public HashMap<String, Object> selectDetail(HashMap<String, Object> map){
		return sqlSessionTemplate.selectOne("book.selectDetail", map);
	}
	
	public List<HashMap<String, Object>> selectList(HashMap<String, Object> map){
		return sqlSessionTemplate.selectList("book.selectList", map);
	}
	 
	public int edit(HashMap<String, Object> map) {
		return sqlSessionTemplate.update("book.update", map);
	}
}
