package com.penn.test.service;

import com.penn.test.SpringTests;
import com.penn.test.jedis.JedisClusterAdapter;
import com.penn.test.vo.PersonVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

public class SpringTestJedisApplicationTests extends SpringTests{

	@Autowired
	private JedisClusterAdapter jedisClusterAdapter;

	@Test
	public void testTryLock() {
		String key = "penns";
		String value = "yyyyyy";
		boolean reulst = jedisClusterAdapter.tryLock(key, value, 120, 10);
		System.out.println("================result:"+ reulst+"===========================");
	}

	@Test
	public void testReleaseLock() {
		String key = "penns";
		String value = "yyyyyy";
		jedisClusterAdapter.releaseLock(key, value);
		System.out.println("================release finished===========================");
	}

	@Test
	public void del(){
		jedisClusterAdapter.del("zhangxiaopeng");
	}

	@Test
	public void testSetOjb(){
		PersonVo vo = new PersonVo();
		vo.setUserName("zhangxiaopeng");
		vo.setAge(100);
		jedisClusterAdapter.set("zhangxiaopeng", 120, vo);
	}

	@Test
	public void testGetOjb(){
		PersonVo vo = jedisClusterAdapter.get("zhangxiaopeng", PersonVo.class);
		System.out.printf("===================vo:" +vo);
	}

}
