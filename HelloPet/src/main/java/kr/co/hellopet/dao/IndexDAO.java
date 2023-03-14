package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.CsVO;
/* 
 *  날짜 : 2023/03/13
 *  이름 : 김채영
 *  설명 : HelloPet Index 페이지 기능구현
 */
@Mapper
@Repository
public interface IndexDAO {
	
	public List<CsVO> selectNotice();
	public List<CsVO> selectFaq();

}
