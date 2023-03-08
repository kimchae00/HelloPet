package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	public void insertMember(MemberVO member);
	public MemberVO selectMember(String uid);
	public List<MemberVO> selectMembers();
	public void updateMember(MemberVO member);
	public void deleteMember(String uid);

}
