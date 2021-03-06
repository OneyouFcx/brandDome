package com.icei.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icei.domain.Template;
import com.icei.domain.UserDetail;

public interface TemplateMapper {
	
	/**
	 * 查询全部优惠券
	 * @return
	 */
	 //分页查询
    List<Template> getTemplate(Map<String, Object> map);
	//模糊查询总条数
    int byConditionGetCount(Map<String, Object> map);
    /**
     * 根据店铺查询优惠券
     * 
     */
    //分页查询
    List<Template> getBrandTemplate(Map<String, Object> map);
	//模糊查询总条数
    int byConditionGetBrandCount(Map<String, Object> map);
    
    List<Template> selectAll(@Param("discountsScope")int discountsScope);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int deleteByPrimaryKey(Integer discountTemplateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insert(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int insertSelective(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    Template selectByPrimaryKey(Integer discountTemplateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKeySelective(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated Thu Apr 19 10:27:54 CST 2018
     */
    int updateByPrimaryKey(Template record);
}