package kr.co.hellopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hellopet.dao.MemberDAO;
import kr.co.hellopet.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void insertMember(MemberVO member) {
		dao.insertMember(member);
	}
	public MemberVO selectMember(String uid) {
		return dao.selectMember(uid);
	}
	public List<MemberVO> selectMembers() {
		return dao.selectMembers();
	}
	public void updateMember(MemberVO member) {
		dao.updateMember(member);
	}
	public void deleteMember(String uid) {
		dao.deleteMember(uid);
	}

}
