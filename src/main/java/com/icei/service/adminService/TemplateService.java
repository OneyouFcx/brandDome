package com.icei.service.adminService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icei.domain.Template;
import com.icei.mapper.TemplateMapper;

/**
 * 优惠券模板业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class TemplateService {
	
	@Autowired
	private TemplateMapper tm;
	
	/**
	 * 得到平台全部优惠券，分页
	 * @param map
	 * @return
	 */
	public List<Template> getTemplate(Map<String, Object> map){
		return tm.getTemplate(map);
	}
	/**
	 * 查询所有根据 
	 * @param discountsScope 平台/店铺
	 * @return
	 */
	public List<Template> selectAll(int discountsScope){
		return tm.selectAll(discountsScope);
	}
	/**
	 * 模糊查询全部优惠券数量
	 * @return
	 */
	public int byConditionGetCount(Map<String, Object> map) {
		return tm.byConditionGetCount(map);
	}
	/**
	 * 添加优惠券模板
	 * @param t
	 * @return
	 */
	public int toAddTemplate(Template t) {
		return tm.insert(t);
	}
	/**
	 * 修改模板信息
	 * @param t
	 * @return
	 */
	public int updataTemplate(Template t) {
		return tm.updateByPrimaryKeySelective(t);
	}
	
	/**
	 * 删除模板
	 * @param id
	 * @return
	 */
	public int deteleTemplate(int id) {
		return tm.deleteByPrimaryKey(id);
	}
	
	//店铺方法
	/**
	 * 得到平台全部优惠券，分页
	 * @param map
	 * @return
	 */
	public List<Template> getBrandTemplate(Map<String, Object> map){
		return tm.getBrandTemplate(map);
	}
	/**
	 * 模糊查询全部优惠券数量
	 * @return
	 */
	public int byConditionGetBrandCount(Map<String, Object> map) {
		return tm.byConditionGetBrandCount(map);
	}
	
}
