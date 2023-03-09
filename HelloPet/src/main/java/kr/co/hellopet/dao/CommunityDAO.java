package kr.co.hellopet.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.CommunityVO;

/*
 * 날짜 : 2023/03/09
 * 이름 : 김경준
 * 설명 : HelloPet 커뮤니티 페이지 기능구현
 */

@Mapper
@Repository
public interface CommunityDAO {
	
	// tip 글쓰기
	public int insertTipArticle(CommunityVO vo);
	
	
}
