package cn.tri.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tri.mapper.UserMapper;
import cn.tri.pojo.User;

public class UserTest {
	private SqlSessionFactory factory;
	@Before
	public void Factory(){
		String resource = "mybaties-config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void getId(){
		SqlSession sqlSession = factory.openSession();
		//使用mapper代理生成实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getId(3);
		System.out.println(user);
		sqlSession.close();
	};
	
	@Test
	public void addUser(){
		User user = new User(3, "zhangsan1", "sanzhang1");
		SqlSession sqlSession = factory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.addUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
}
