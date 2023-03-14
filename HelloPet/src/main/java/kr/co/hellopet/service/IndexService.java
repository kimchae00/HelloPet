package kr.co.hellopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hellopet.dao.IndexDAO;
import kr.co.hellopet.vo.CsVO;

@Service
public class IndexService {
	
	@Autowired
	private IndexDAO dao;
	
	public List<CsVO> selectNotice(){
		return dao.selectNotice();
	}
	public List<CsVO> selectFaq(){
		return dao.selectFaq();
	}
	
	public int getCurrentPage(String pg) {
	  int currentPage = 1;
	
	  if(pg != null) {
	      currentPage = Integer.parseInt(pg);
	  }
	  return currentPage;
	}

}
