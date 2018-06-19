package com.icei.web.controller.iceiadmin;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.icei.domain.UserDetail;
import com.icei.service.adminService.UserService;
import com.icei.utils.ResultUtil;

/**
 * 平台用户控制层
 * @author YU生俱来
 *
 */
@Controller
@RequestMapping("admin/user")
public class UserController {
	
	@Autowired
	private  UserService us;
	/**
	 * 中转进入界面
	 * @return
	 */
	@GetMapping("/users.html")
    public String toAdmin(){
		return"/iceiAdmin/user/users";  
    }
	/**
	 * 模糊查询平台用户
	 * @param req
	 * @param page 从第几条显示
	 * @param limit 每页显示多少条
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getPage")
	public Object getPage(HttpServletRequest req,@Param("page")int page,@Param("limit")int limit) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", (page*limit-limit));
		map.put("pageSize", limit);
		//ID非空判断
		if(req.getParameter("userId")!=null && !req.getParameter("userId").equals("")) {
			int num=Integer.parseInt(req.getParameter("userId"));
			map.put("userId", num);
		}
		//用户注册开始日期非空判断
		if(!req.getParameter("creationDate").equals("")&&req.getParameter("creationDate")!=null) {
			map.put("creationDate", req.getParameter("creationDate"));
		}else {
			map.put("creationDate",null);
		}
		//用户注册开始日期非空判断，使用两个日期的区间查询用户
		if(!req.getParameter("creationDate1").equals("")&&req.getParameter("creationDate1")!=null) {
			map.put("creationDate1", req.getParameter("creationDate1"));
		}else {
			map.put("creationDate1",null);
		}
		map.put("userName", req.getParameter("userName"));
		return ResultUtil.success(us.getUserPage(map),us.byTiaogetCount(map));
	}
	/**
	 * 修改用户状态
	 * @param userStatus
	 * @return
	 */
	@PutMapping("/updateUser")
	@ResponseBody
	public int updateUser(@Param("userId")int userId,@Param("userStatus") int userStatus) {
		UserDetail ud=new UserDetail();
		ud.setUserId(userId);
		ud.setUserStatus(userStatus);
		return us.updateUser(ud);
	}
	
}
