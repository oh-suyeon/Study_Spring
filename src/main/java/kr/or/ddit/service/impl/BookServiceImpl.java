package kr.or.ddit.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public String create(HashMap<String, Object> map) {
		int affectRowCnt = bookDao.insert(map);
		if(affectRowCnt == 1) {
			return "1";
		}
		return null;
	}

	@Override
	public HashMap<String, Object> selectDetail(HashMap<String, Object> map) {
		return bookDao.selectDetail(map);
	}

	@Override
	public List<HashMap<String, Object>> selectList(HashMap<String, Object> map) {
		return bookDao.selectList(map);
	}

	@Override
	public int edit(HashMap<String, Object> map) {
		int affectRowCnt = bookDao.edit(map);
		return affectRowCnt;
	}

}
