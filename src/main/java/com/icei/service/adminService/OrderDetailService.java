package com.icei.service.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.OrderDetail;
import com.icei.mapper.OrderDetailMapper;
/**
 * 
 * @author YU生俱来
 *
 */
@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	/**
	 * 根据订单id获取商品图片
	 * @param orderId
	 * @return
	 */
	public OrderDetail byOrderIdGetGoodsInfo(int orderId) {
		return orderDetailMapper.selectByPrimaryKey(orderId);
	}
}
