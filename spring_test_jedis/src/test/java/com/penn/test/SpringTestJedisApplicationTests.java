package com.penn.test;

import com.penn.test.jedis.JedisClusterAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ContextConfiguration("/applicationContext.xml")
public class SpringTestJedisApplicationTests {

	@Autowired
	private JedisClusterAdapter jedisClusterAdapter;

	@Test
	public void testSetStr() {
		String key = "penns";
		String value = "penn"+ Calendar.getInstance().getTimeInMillis();
		boolean reulst = jedisClusterAdapter.set(key, 600, value);
		System.out.println("================result:"+ reulst+"===========================");
	}

}
