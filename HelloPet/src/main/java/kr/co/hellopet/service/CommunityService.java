package kr.co.hellopet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hellopet.dao.CommunityDAO;
import kr.co.hellopet.vo.CommunityVO;

/*
 * 날짜 : 2023/03/09
 * 이름 : 김경준
 * 설명 : HelloPet 커뮤니티 페이지 기능구현
 */

@Service
public class CommunityService {

	@Autowired
	private CommunityDAO dao;
	
	// tip 글쓰기
	public int insertTipArticle(CommunityVO vo) {
		return dao.insertTipArticle(vo);
	}
}
