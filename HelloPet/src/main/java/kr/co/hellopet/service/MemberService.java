package kr.co.hellopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.hellopet.dao.MemberDAO;
import kr.co.hellopet.vo.MemberVO;

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

}
