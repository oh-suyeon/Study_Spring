package kr.or.ddit.dao;

import java.util.HashMap;

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
		return sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
}
