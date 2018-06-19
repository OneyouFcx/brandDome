package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icei.domain.AssessImg;
import com.icei.domain.OrderAssess;
import com.icei.mapper.AssessImgMapper;
import com.icei.mapper.OrderAssessMapper;
/**
 * 商品评论
 * @author only
 *
 */
@Service
public class OrderAssessService {
	@Autowired
	private OrderAssessMapper orderAssess;
	@Autowired
	private AssessImgMapper assessImgMapper;
	/**
	 * 评论和谐
	 * @param assessId
	 * @return
	 */
	public int updHarmonious(int assessId){
		OrderAssess oa=new OrderAssess();
		oa.setAssessId(assessId);
		oa.setAssessDec("这个评论已经被捉拿");
		assessImgMapper.delAssessImg(assessId);//删除图片
		return orderAssess.updateByPrimaryKeySelective(oa);
	}
	/**
	 * 系统删除评论
	 * @param assessId
	 * @return
	 */
	public int delAssess(Integer assessId) {
		return orderAssess.deleteByPrimaryKey(assessId);
	}
	/**
	 * 添加评论
	 * @param assess
	 * @return
	 */
	@Transactional
	public int addOrderAssess(OrderAssess assess,AssessImg assessImg) {
		int num=orderAssess.insert(assess);
		/*添加评价照片*/
		assessImg.setAssessId(assess.getAssessId());//最新添加评论的id
		assessImgMapper.insert(assessImg);
		return num;
	}
}
