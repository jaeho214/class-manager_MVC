package com.dev;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dev.dao.MemberDao;
import com.dev.mapper.MemberMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassManagerApplicationTests {
	
	@Autowired
	private MemberMapper memberMapper;
	

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void test1() {
		System.out.println(memberMapper.getTime());
	}
}
