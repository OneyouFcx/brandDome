package com.icei.service.adminService;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.UserDetail;
import com.icei.mapper.UserDetailMapper;

/**
 * 平台用户业务逻辑层
 * @author YU生俱来
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserDetailMapper udm;
	/**
	 * 得到全部平台用户
	 * @return
	 */
	public List<UserDetail> getUserPage(Map<String, Object> map){
		return udm.getUserPage(map);
	}
	//查询总条数
	public int getCount() {
		return udm.getCount();
	}
	//模糊查询总条数
	public int byTiaogetCount(Map<String, Object> map) {
		return udm.ByTiaogetCount(map);
	}
	
	//修改用户状态
	public int updateUser(UserDetail ud) {
		return udm.updateByPrimaryKeySelective(ud);
	}
	/**
	 * 添加用户
	 * @param ud
	 * @return
	 */
	public int addUser(UserDetail ud) {
		return udm.insert(ud);
	}
	/**
	 * 对外接口修改用户
	 * @param ud
	 * @return
	 */
	public int portUpdateUser(UserDetail ud) {
		return udm.updateByPrimaryKeySelective(ud);
	}
}
