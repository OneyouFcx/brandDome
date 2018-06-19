package com.icei.mapper;

import java.util.*;

import com.icei.domain.OrderRefund;
import org.apache.ibatis.annotations.Param;

public interface OrderRefundMapper {

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderRefund record);

    int insertSelective(OrderRefund record);

    OrderRefund selectByPrimaryKey(@Param("orderId")int orderId);

    int updateByPrimaryKeySelective(OrderRefund record);

    int updateByPrimaryKey(OrderRefund record);
    /**
     * 得到全部退款订单
     * 根据订单号，订单退款状态查询
     * @return
     */
    List<OrderRefund> getAll(Map<String,Object> map);
    /**
     * 得到全部总条数
     * @param map
     * @return
     */
    int getCount(Map<String,Object> map);
    /**
     * id和店铺id查询退款记录
     * @param id
     * @param brandId
     * @return
     */
    OrderRefund findOrderRefundByIdAndBrandId(@Param("id") Integer id,@Param("brandId") Integer brandId);
}