package com.icei.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icei.domain.Award;
import com.icei.mapper.AwardMapper;
/**
 * 奖励
 * @author AdminFcx
 *
 */
@Service
public class AwardService {
	
	@Autowired
	public AwardMapper awardMapper;
	/**
	 * 查询全部
	 * @param awardTypeid
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Award> GetAllMsg(String userName,int awardTypeid,int page,int limit){
		page=(page-1)*limit;
		return awardMapper.getAllmsg(userName,awardTypeid, page, limit);
	}
	/**
	 * 查询总条数
	 * @param awardTypeid
	 * @return
	 */
	public int GetAllMsgCount(String userName,int awardTypeid) {
		return awardMapper.getAllmsgCount(userName,awardTypeid);
	}
}
