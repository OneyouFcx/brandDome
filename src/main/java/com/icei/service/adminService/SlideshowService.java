package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.Slideshow;
import com.icei.mapper.SlideshowMapper;

/**
 * 主页轮播业务逻辑层
 * @author 小诺诺
 *
 */
@Service
public class SlideshowService {
	@Autowired
	private SlideshowMapper slideshowMapper;
	
	/**
	 * 获取全部轮播
	 * @return
	 */
	public List<Slideshow> getSlideAll(){
		return slideshowMapper.getSlideAll();
	}
	
	/**
	 * 添加轮播
	 * @param slide
	 * @return
	 */
	public int addSlideshow(Slideshow slide) {
		return slideshowMapper.insertSelective(slide);
	}
	
	/**
	 * 删除轮播
	 * @param id
	 * @return
	 */
	public int delSlideshow(Integer id) {
		return slideshowMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 修改轮播
	 * @param slideshow
	 * @return
	 */
	public int updSlideshow(Slideshow slideshow) {
		return slideshowMapper.updateByPrimaryKeySelective(slideshow);
	}
}
