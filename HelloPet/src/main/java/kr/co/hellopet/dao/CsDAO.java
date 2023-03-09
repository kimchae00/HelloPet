package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.CsVO;

@Mapper
@Repository
public interface CsDAO {

	public int insertNotice(CsVO vo);
	public List<CsVO> selectNotices(@Param("start") int start);
	public int selectCountTotalNotice();
	
	public int insertQna();
	public int insertFaq();
}
