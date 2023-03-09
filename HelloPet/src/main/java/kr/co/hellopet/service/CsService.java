package kr.co.hellopet.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hellopet.dao.CsDAO;
import kr.co.hellopet.vo.CsVO;

@Service
public class CsService {
	
	@Autowired
	private CsDAO dao;
	
	public int insertNotice(CsVO vo) {
		int result = 0;
		// 썸네일 이미지 경로 지정
		String newFile = imgUpload(vo);
		
		if(newFile != null) {
			vo.setImg("/HelloPet/file/"+newFile);
		}else {
			vo.setImg(null);
		}
		
		result = dao.insertNotice(vo);
		return result;
	}
	
	public List<CsVO> selectNotices(int start){
		return dao.selectNotices(start);
	}
	public int selectCountTotalNotice() {
		return dao.selectCountTotalNotice();
	}
	
	// 파일 이미지
	@Value("${spring.servlet.multipart.location}")
    private String uploadPath;
	
	public String imgUpload(CsVO vo) {
		 MultipartFile img = vo.getFileimg();
		 String newFile = null;

 		if(!img.isEmpty()) {
 			String path = new File(uploadPath).getAbsolutePath();
             
             // 새 파일명 생성
         	 String oName = img.getOriginalFilename();
         	 int idx = oName.lastIndexOf(".");
             String ext = oName.substring(idx); // 확장자
             String nName = UUID.randomUUID().toString()+ext;
             
             try {
             	img.transferTo(new File(path, nName));
             	newFile = nName;
             } catch (IllegalStateException e) {
                 e.printStackTrace();
             } catch (IOException e) {
             	e.printStackTrace();
 			}
 		}
		return newFile;
    }
	
	/////////// 페이징 처리 ////////////
	// 현재 페이지 번호
	public int getCurrentPage(String pg) {
	  int currentPage = 1;
	
	  if(pg != null) {
	      currentPage = Integer.parseInt(pg);
	  }
	  return currentPage;
	}
	
	// 페이지 시작값
	public int getLimitStart(int currentPage) {
	  return (currentPage - 1) * 10;
	}
	
	// 마지막 페이지 번호
	public int getLastPageNum(int total) {
	
	  int lastpageNum = 0;
	
	  if(total % 10 == 0) {
	      lastpageNum = total / 10;
	
	  }else {
	      lastpageNum = total / 10 + 1;
	  }
	  return lastpageNum;
	}
	
	// 페이지 시작 번호
	public int getpageStartNum(int total, int start) {
	  return total - start;
	}
	
	// 페이지 그룹
	public int[] getPageGroup(int currentPage, int lastPageNum) {
	
	  int groupCurrent = (int) Math.ceil(currentPage / 10.0);
	  int groupStart = (groupCurrent - 1) * 10 + 1;
	  int groupEnd = groupCurrent * 10;
	
	  if(groupEnd > lastPageNum) {
	      groupEnd = lastPageNum;
	  }
	
	  int[] groups = {groupStart, groupEnd};
	
	  return groups;
	}
}
