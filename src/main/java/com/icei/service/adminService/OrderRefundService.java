package com.icei.service.adminService;

import com.icei.domain.OrderRefund;
import com.icei.mapper.OrderRefundMapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 退款申请
 */
@Service
public class OrderRefundService {

    @Autowired
    private OrderRefundMapper orderRefundMapper;
    
    public OrderRefund getOne(int orderId) {
    	return orderRefundMapper.selectByPrimaryKey(orderId);
    }
    
    /**
	 * 得到全部退款订单
	 * 根据订单号，订单退款状态查询
	 * @return
	 */
	public List<OrderRefund> getAll(Map<String,Object> map){
		return orderRefundMapper.getAll(map);
	}
	/**
	 * 得到总条数
	 * @param map
	 * @return
	 */
	public int getCount(Map<String,Object> map) {
		return orderRefundMapper.getCount(map);
	}


	/**
	 * id和店铺id查询退款记录
	 * @param id
	 * @param brandId
	 * @return
	 */
	public OrderRefund findOrderRefundByIdAndBrandId(Integer id,Integer brandId){
		return  orderRefundMapper.findOrderRefundByIdAndBrandId(id,brandId);
	};
	
	/**
	 * 修改订单状态
	 * @param orderRefund
	 * @return
	 */
	public int updateOrder(OrderRefund orderRefund) {
		return orderRefundMapper.updateByPrimaryKeySelective(orderRefund);
	}
	
	/**
	 * 申请退款
	 */
	public int addOrderRefund(OrderRefund o) {
		return orderRefundMapper.insert(o);
	}
	
	/**
	 * 删除退款订单信息
	 * @param orderId
	 * @return
	 */
	public int deteleInfo(int orderId) {
		return orderRefundMapper.deleteByPrimaryKey(orderId);
	}
}
