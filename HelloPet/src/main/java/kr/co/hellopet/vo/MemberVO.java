package kr.co.hellopet.vo;

import java.sql.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
	
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private String nick;
	private String email;
	private int type;
	private int level;
	private String zip;
	private String addr1;
	private String addr2;
	private String regip;
	private Date wdate;
	private Date rdate;
	
	//추가데이터

}
