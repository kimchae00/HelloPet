package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.CsVO;

@Mapper
@Repository
public interface IndexDAO {
	
	public List<CsVO> selectNotice();
	public List<CsVO> selectFaq();

}
