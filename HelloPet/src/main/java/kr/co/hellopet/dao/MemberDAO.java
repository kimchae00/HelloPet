package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.hellopet.vo.MedicalVO;
import kr.co.hellopet.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	// 일반회원등록
	public void insertMember(MemberVO vo);
	
	// 병원·약국 등록
	public void insertMedical(MedicalVO vo);
	
	public MemberVO selectMember(String uid);
	public List<MemberVO> selectMembers();
	public void updateMember(MemberVO vo);
	public void deleteMember(String uid);
	
	// uid 중복체크
	public int countUid(String uid);
	
	// hp 중복체크
	public int countHp(String hp);
	
	// email 중복체크
	public int countEmail(String email);
	
	// nick 중복체크
	public int countNick(String nick); 
}
