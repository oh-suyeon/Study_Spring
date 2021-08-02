package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public int create(Map<String, Object> map) {
		return bookDao.insert(map);
	}
	
	@Override
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return bookDao.selectDetail(map);
	}

	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return bookDao.selectList(map);
	}
	
	@Override
	public int count(Map<String, Object> map) {
		return bookDao.count(map);
	}

	@Override
	public List<Map<String, Object>> selectListPage(Map<String, Object> map) {
		return bookDao.selectListPage(map);
	}

	@Override
	public int edit(Map<String, Object> map) {
		return bookDao.edit(map);
	}

}
