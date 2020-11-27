package com.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.mapper.UserMapper;
import com.po.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserTest {
	@Test
	public void findUserTest() {
		//SqlSession session = MybatisUtils.getSession();
	}
}
