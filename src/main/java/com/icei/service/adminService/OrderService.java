package com.icei.service.adminService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icei.domain.*;
import com.icei.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.enums.ResultEnums;
import com.icei.mapper.BrandGoodsMapper;
import com.icei.mapper.DiscountsMapper;
import com.icei.mapper.OrderDetailMapper;
import com.icei.mapper.OrderMapper;
import com.icei.exception.IceiExeption;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单业务层
 * 
 * @author:LordMasterKing
 * @date:2018年4月27日
 */
@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private BrandGoodsMapper brandGoodsMapper;

	@Autowired
	private DiscountsMapper discountsMapper;

	/**
	 * 查询店铺所有订单记录
	 * 
	 * @author:LordMasterKing
	 * @date:2018年4月27日
	 */
	public Map<String, Object> findOrdersByConditions(Integer orderStatus, String startDate, String endDate, String orderIndex,Integer brandId,Integer page,Integer pageSize) throws Exception {
		int count= orderMapper.findOrdersCountByConditions(orderStatus, startDate, endDate, orderIndex, brandId);//数量
		List<Order> list = orderMapper.findOrdersByConditions(orderStatus, startDate, endDate, orderIndex, brandId,page,pageSize);
		Map<String,Object> map=new HashMap<>();
		map.put("count",count);
		map.put("list",list);
		return map;
	}

	/**
	 * 新增订单记录
	 * 
	 * @author:LordMasterKing
	 * @date:2018年5月2日
	 */
	@Transactional
	public Result addNewOrder(Integer userId, Integer addressId, Integer goodsId, Integer num, Integer diyMould,
			Integer typeMould, Integer discountsId, Integer goodsSize,Integer paymentId) {

		BrandGoods goods = brandGoodsMapper.selectByPrimaryKey(goodsId);
		Discounts discounts = discountsMapper.selectByPrimaryKey(discountsId);

		String orderIndex = GenerateNum.getInstance().GenerateOrder();

		Double orderPrice = Arith.add(Arith.mul(Arith.mul(goods.getGoodsPrice(), num),goods.getGoodsDiscount()),((diyMould == null) ? 0 : goods.getDiyPrice()));

		if(discounts!=null&&orderPrice<discounts.getBigMoney())
			throw new IceiExeption(ResultEnums.IllEGAL_OPTION);

		Integer discountMoney = (discounts == null) ? 0 : discounts.getSmallMoney();//定制金额
		Double temp=Arith.mul(orderPrice, goods.getGoodsDiscount());//订单总价
		Double orderMoney = Arith.sub(orderPrice, discountMoney);//订单金额



		// 插入新订单操作
        Order order=new Order();
        order.setUserId(userId);
        order.setOrderIndex(orderIndex);
        order.setAddressId(addressId);
        order.setOrderPrice(orderPrice);
        order.setOrderMoney(orderMoney);
        order.setDiscountsMoney(orderPrice-orderMoney);
        order.setDiscountsId(discountsId);
        order.setPaymentId(paymentId);
        int orderResult=orderMapper.insertSelective(order);

		// 插入订单详情
		int detailResult = orderDetailMapper.insertByOrderIndex(orderIndex, goodsId, num, diyMould, typeMould,
				goods.getGoodsPrice(), goodsSize,goods.getGoodsDiscount(),goods.getBrandId());

		if (orderResult > 0 && detailResult > 0) {
			return ResultUtil.success(orderIndex);
		}

		throw new IceiExeption(ResultEnums.UNKNOWN_ERROR);
	}

	/**
	 * 订单号和用户id查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public Order findAOrderByOrderNumber(String orderIndex,Integer userId){
		return orderMapper.findAOrderByOrderNumber(orderIndex,userId);
	}
	/**
	 * id和用户id查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public Order findAOrderById(int orderId,Integer userId){
		return orderMapper.findAOrderById(orderId,userId);
	}

	/**
	 * id 和 店铺id 查询订单
	 * @param orderId
	 * @param brandId
	 * @return
	 */
	public Order findAOrderByIdAndBrandId(int orderId,Integer brandId){
		return orderMapper.findAOrderByIdAndBrandId(orderId,brandId);
	}
	/**
	 * 更新订单
	 * @param trade_index 交易号
	 * @param order_status 状态
	 * @param paid_date 交易时间
	 * @return
	 * @throws ParseException
	 */
	public int updateByPrimaryKeySelective(String orderIndex,String trade_index,Integer order_status,String paid_date) throws ParseException {
		Order order=new Order();
		order.setOrderIndex(orderIndex);
		order.setTradeIndex(trade_index);
		order.setStatusId(order_status);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setPaidDate(sdf.parse(paid_date));
		return orderMapper.updateByPrimaryKeySelective(order);
	}


	/**
	 * 更新订单状态
	 * @param statusId
	 * @return
	 */
	public int updOrderStatus(String orderIndex,Integer statusId){
		Order order=new Order();
		order.setOrderIndex(orderIndex);
		order.setStatusId(statusId);
		return orderMapper.updateByPrimaryKeySelective(order);
	}
	
	/**
	 * 查询个人订单(全部,待发货，代付款，待收货，带评价)
	 */
	public List<Order> getUserOrder(int userId,Integer statusId){
		return orderMapper.getUserOrder(statusId, userId);
	}
	/**
	 * 查询个人订单 退款
	 */
	public List<Order> getUserOrderRefund(int userId){
		return orderMapper.getUserOrderRefund(userId);
	}

	/**
	 * 更新快递
	 * @param orderIndex 订单号
	 * @param expId 快递id
	 * @param expType 快递类型
	 * @return
	 */
	public int updEsc(String orderIndex,String expId,String expType){
		Order order=new Order();
		order.setOrderIndex(orderIndex);
		order.setExpId(expId);
		order.setExpType(expType);
		order.setSendDate(new Date());
		order.setStatusId(3);
		return orderMapper.updateByPrimaryKeySelective(order);
	}
	/**
	 * 修改订单
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public int updateOrder(Order order) {
		return orderMapper.updateOrder(order);
	}

}
