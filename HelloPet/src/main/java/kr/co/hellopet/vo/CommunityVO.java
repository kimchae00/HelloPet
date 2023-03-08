package kr.co.hellopet.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommunityVO {
	private int no;
	private String uid;
	private int parent;
	private String group;
	private String title;
	private String content;
	private MultipartFile img1;
	private MultipartFile img2;
	private MultipartFile img3;
	private int hit;
	private int heart;
	private String regip;
	private String rdate;
}
