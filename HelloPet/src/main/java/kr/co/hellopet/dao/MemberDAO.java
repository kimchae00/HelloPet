package kr.co.hellopet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hellopet.vo.Api_HospitalVO;
import kr.co.hellopet.vo.Api_PharmacyVO;
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
	
	// register Medical 검색기능
	public List<Api_HospitalVO> selectMedical(@Param("trial") String trial, 
											  @Param("county") String county, 
											  @Param("name") String name);
	
	// register Pharmacy 검색기능
	public List<Api_PharmacyVO> selectPharmacy(@Param("trial") String trial, 
											   @Param("county") String county, 
											   @Param("name") String name);
	
	// uid(회원) 중복체크
	public int countUid(String uid);
	
	// uid(Medical) 중복체크
	public int countMedicalUid(String uid);
	
	// hp 중복체크
	public int countHp(String hp);
	
	// hp Medical 중복체크
	public int countMedicalHp(String hp); 	
	
	// email 중복체크
	public int countEmail(String email);
	
	// email 중복체크
	public int countMedicalEmail(String email);
	
	// nick 중복체크
	public int countNick(String nick); 
	
	// find ID 찾기
	public MemberVO selectFindId(@Param("name") String name, @Param("hp") String hp);
	
	// find paswword 
	public int selectCountMemberForChangePass(@Param("email") String email, @Param("name") String name, @Param("hp") String hp);
	
	// find password update
	public void updatePetOwnerPasswordByCodeAndInfo(@Param("pass") String pass, @Param("email") String email, @Param("name") String name, @Param("hp") String hp);
	
	public MemberVO selectGetUserInfo (@Param("email") String email, @Param("name") String name, @Param("hp") String hp);
	
	public void updateUser(String pass, String email, String name, String hp);
}
