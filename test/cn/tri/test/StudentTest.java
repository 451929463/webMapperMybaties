package cn.tri.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import cn.tri.pojo.Student;

public class StudentTest {
	private SqlSessionFactory factory = null;
	@Before
	public void init() throws IOException{
		String str = "mybaties-config.xml";
		InputStream is = Resources.getResourceAsStream(str);
		factory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void findGetId(){
		SqlSession session = factory.openSession();
		String statement = "cn.tri.mapper.StudentMapper.findGetId";
		Student s = session.selectOne(statement,1);
		System.out.println(s);
	}
}
