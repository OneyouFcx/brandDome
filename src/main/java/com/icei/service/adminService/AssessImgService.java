package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.AssessImg;
import com.icei.mapper.AssessImgMapper;

@Service
public class AssessImgService {
	@Autowired
	private AssessImgMapper assessImgMapper;
	
	/**
	 * 添加评论图片
	 * @param assessImg
	 * @return
	 */
	public int addAssessImg(AssessImg assessImg) {
		return assessImgMapper.insert(assessImg);
	}
}
