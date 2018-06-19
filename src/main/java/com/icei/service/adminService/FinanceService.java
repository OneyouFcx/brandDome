package com.icei.service.adminService;

import com.icei.domain.Result;
import com.icei.enums.ResultEnums;
import com.icei.mapper.OrderMapper;
import com.icei.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinanceService {
    @Autowired
    private OrderMapper orderMapper;

    public Result findTargetOrderInfoByBrandIdAndDate(Integer brandId, String startDate, String endDate){
        Map<String,Object> map= orderMapper.findTargetOrderInfoByBrandIdAndDate(brandId, startDate, endDate);
        for (String str:map.keySet()) {
            System.out.println(str+"-"+map.get(str));
        }
        if(map!=null){
            return ResultUtil.success(map);
        }
        return ResultUtil.error(ResultEnums.UNKNOWN_ERROR.getCode(),ResultEnums.UNKNOWN_ERROR.getMsg());
    }
    public Result findTargetOrderByBrandIdAndDate(Integer brandId, String startDate, String endDate){
        List<HashMap<String,Object>> list=orderMapper.findTargetOrderByBrandIdAndDate(brandId, startDate, endDate);
        Map<String,Object>successMap=new HashMap<String,Object>();
        Map<String,Object>failMap=new HashMap<String,Object>();
        Map<String,Float>AllMoneyMap=new HashMap<String,Float>();
        for (HashMap<String,Object> listMap :list) {
            Timestamp timestamp=(Timestamp)listMap.get("creation_date");
            DateFormat df=new SimpleDateFormat("MM-dd");
            String date=df.format(timestamp);
            if(successMap.get(date)==null){
                if(9==(Integer)listMap.get("status_id")){
                    failMap.put(date,0);
                }else{
                    successMap.put(date,0);
                }
                AllMoneyMap.put(date,0f);
            }
            if(9==(Integer)listMap.get("status_id")){
                int num=(Integer)failMap.get(date);
                num++;
                failMap.put(date,num);
                Float money=(Float)AllMoneyMap.get(date);
                Float itemMoney=(Float)listMap.get("order_price");
                AllMoneyMap.put(date,money-itemMoney);
            }else{
                int num=(Integer)successMap.get(date);
                num++;
                successMap.put(date,num);
                Float money=(Float)AllMoneyMap.get(date);
                Float itemMoney=(Float)listMap.get("order_price");
                AllMoneyMap.put(date,money+itemMoney);
            }
        }
        Map<String,Object>resultMap=new HashMap<String,Object>();
        resultMap.put("success",successMap);
        resultMap.put("fail",failMap);
        resultMap.put("allMoney",AllMoneyMap);
        return  ResultUtil.success(resultMap);
    }
}
