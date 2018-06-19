package com.icei.mapper;

import java.util.List;
import java.util.Map;

import com.icei.domain.OrderStatus;
import org.apache.ibatis.annotations.Param;

import com.icei.domain.Order;

public interface OrderMapper {
	/**
	 * 修改订单
	 * @param orderId
	 * @return
	 */
	 int updateOrder(Order order);
	/**
	 * 查询个人订单(全部,待发货，代付款，待收货，退款，带评价)
	 * @param statusId
	 * @return
	 */
	 List<Order> getUserOrder(@Param("statusId")Integer statusId,@Param("userId")int userId);
	 /**
	 * 查询个人订单(退款)
	 * @param statusId
	 * @return
	 */
	 List<Order> getUserOrderRefund(@Param("userId")int userId);

	/**
	 * 订单数量
	 * @param orderStatus
	 * @param startDate
	 * @param endDate
	 * @param orderIndex
	 * @param brandId
	 * @return
	 */
	int findOrdersCountByConditions(@Param("orderStatus") Integer orderStatus, @Param("startDate") String startDate,
									@Param("endDate") String endDate, @Param("orderIndex") String orderIndex,
									@Param("brandId") Integer brandId);

	/**
	 * 店铺订单集合
	 * @param orderStatus
	 * @param startDate
	 * @param endDate
	 * @param orderIndex
	 * @param brandId
	 * @return
	 */
	List<Order> findOrdersByConditions(@Param("orderStatus") Integer orderStatus, @Param("startDate") String startDate,
									   @Param("endDate") String endDate, @Param("orderIndex") String orderIndex,
									   @Param("brandId") Integer brandId,@Param("page")Integer page,@Param("pageSize")Integer pageSize);

	/**
	 * 添加订单
	 * @param userId
	 * @param orderIndex
	 * @param addressId
	 * @param orderPrice
	 * @param orderMoney
	 * @param discountsMoney
	 * @param discountsId
	 * @return
	 */
	int addNewOrder(@Param("userId")Integer userId,@Param("orderIndex")String orderIndex,@Param("addressId")Integer addressId,@Param("orderPrice")Double orderPrice,@Param("orderMoney")Double orderMoney,@Param("discountsMoney")Double discountsMoney,@Param("discountsId")Integer discountsId);

	/**
	 * 订单号和用户id查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 */
	Order findAOrderByOrderNumber(@Param("orderId") String orderId,@Param("userId") Integer userId);
	/**
	 * 订单ID和用户ID查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 */
	Order findAOrderById(@Param("orderId") int orderId,@Param("userId") Integer userId);

	/**
	 * id 和 店铺id 查询订单
	 * @param orderId
	 * @param brandId
	 * @return
	 */
	Order findAOrderByIdAndBrandId(@Param("orderId")int orderId,@Param("brandId")Integer brandId);


    /**
     * 添加订单
     * @param order
     * @return
     */
    int insertSelective(Order order);

	/**
	 * 修改
	 * @param order
	 * @return
	 */
	int updateByPrimaryKeySelective(Order order);

	Map<String,Object> findTargetOrderInfoByBrandIdAndDate(@Param("brandId") Integer brandId,@Param("startDate") String startDate,@Param("endDate") String endDate);

    List findTargetOrderByBrandIdAndDate(@Param("brandId") Integer brandId,@Param("startDate") String startDate,@Param("endDate") String endDate);
}