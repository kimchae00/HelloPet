package kr.co.hellopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.hellopet.dao.MemberDAO;
import kr.co.hellopet.vo.MedicalVO;
import kr.co.hellopet.vo.MemberVO;

/*
 * 날짜 : 2023/03/08
 * 담당 : 이민혁
 * 내용 : member 기능구현
 * 
 */

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void insertMember(MemberVO vo) {
		
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		dao.insertMember(vo);
	};
	
	public void insertMedical(MedicalVO vo) {
		
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		dao.insertMedical(vo);
	};
	
	public MemberVO selectMember(String uid) {
		return dao.selectMember(uid);
	};
	
	public List<MemberVO> selectMembers() {
		return dao.selectMembers();
	};
	
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	};
	
	public void deleteMember() {
		dao.deleteMember(null);
	};
	
	
	public int countUid(String uid) {
		int result = dao.countUid(uid);
		return result;
	}
	
	public int countHp(String hp) {
		int result = dao.countHp(hp);
		return result;
	}
	
	public int countEmail(String email) {
		int result = dao.countEmail(email);
		return result;
	}
	
	public int countNick(String nick) {
		int result = dao.countNick(nick);
		return result;
	}
}
