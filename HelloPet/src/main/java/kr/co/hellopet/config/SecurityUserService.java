package kr.co.hellopet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.hellopet.dao.MemberDAO;
import kr.co.hellopet.entity.MemberEntity;
import kr.co.hellopet.repo.MedicalRepo;
import kr.co.hellopet.repo.MemberRepo;

@Service
public class SecurityUserService  implements UserDetailsService{
	
	@Autowired
	private MemberRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		MemberEntity member = repo.findById(username).get();
		
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails userDts = MyUserDetails.builder().member(member).build();
		
		return userDts;
	}

}
