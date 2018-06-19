package com.icei;

import com.alibaba.fastjson.JSONArray;
import com.icei.service.adminService.BrandHotService;
import com.icei.service.adminService.GoodsInfoService;
import com.icei.utils.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private MailUtil MailUtil;
	@Test
	public void testSimpleMail() throws Exception {
        MailUtil.sendSimpleMail("1959523328@qq.com","你好,^(*￣(oo)￣)^","你好，^(*￣(oo)￣)^");
	}


}