package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.SearchVO;
/*
 * 날짜 : 2023-03-09 ~
 * 이름 : 장인화
 * 내용 : search dao 작성 
 * */

@Mapper
@Repository
public interface SearchDAO {
	
	//searchHs 검색 후 목록 출력하기
	public List<SearchVO> SearchHs(String search);
	public List<SearchVO> SearchHsName(String search);
	public List<SearchVO> SearchHsAddr(String search);
	public int selectSearchHsTotal(String search);
	
	//view
	public SearchVO selectView(String hosNo);

}
