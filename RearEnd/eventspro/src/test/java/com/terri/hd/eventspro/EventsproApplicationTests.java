package com.terri.hd.eventspro;

import com.terri.hd.eventspro.utils.AliOssUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventsproApplicationTests {

	@Autowired
	AliOssUtil ossUtil;

	@Test
	void contextLoads() {

		System.out.println(ossUtil.getAccessKeyId());
		System.out.println(ossUtil.getAccessKeySecret());

	}

}
