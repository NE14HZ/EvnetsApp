package com.terri.hd.eventspro;

import com.terri.hd.eventspro.utils.UuidUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventsproApplicationTests {

	@Test
	void contextLoads() {

		for (int i = 0; i < 10; i++) {
			UuidUtil uuidUtil = new UuidUtil();
			System.out.println(uuidUtil.getUuid());
		}

	}

}
