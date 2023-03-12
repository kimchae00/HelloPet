package kr.co.hellopet.dao;

import java.util.List;

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
	
	// tip 글목록
	public List<CommunityVO> selectTipArticles(int start);
	
	// tip 글목록 갯수
	public int selectTipCount();
	
	// tip 글보기
	public CommunityVO selectTipArticle(int no);
	
	// tip 글수정
	public int updateTipArticle(CommunityVO vo);
	
	// talk 글쓰기
	public int insertTalkArticle(CommunityVO vo);
	
	// talk 글목록
	public List<CommunityVO> selectTalkArticles(int start);
	
	// talk 글목록 갯수
	public int selectTalkCount();
	
	// talk 글보기
	public CommunityVO selectTalkArticle(int no);
	
	// talk 글수정
	public int updateTalkArticle(CommunityVO vo);
}
