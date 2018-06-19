package com.icei.service.adminService;

import com.icei.domain.DiyMould;
import com.icei.mapper.DiyMouldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定制模板
 */
@Service
public class DiyMouleService {
    @Autowired
    private DiyMouldMapper diyMouldMapper;

    /**
     * 用户添加定制模板
     * @param img
     * @param back
     * @return
     */
    @Transactional
    public int addDiyMould(String img,String back){
        DiyMould diyMould=new DiyMould();
        diyMould.setMouldImg(img);
        diyMould.setMouldBack(back);
        diyMouldMapper.insertSelective(diyMould);
        return diyMould.getDiyId();
    }

    /**
     * id获取模板
     * @param diyId
     * @return
     */
    public DiyMould getADiyMould(Integer diyId){
        return diyMouldMapper.selectByPrimaryKey(diyId);
    }
}
