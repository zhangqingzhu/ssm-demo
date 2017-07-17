package cn.com.chnsys.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.com.chnsys.mapper.UserMapper;
import cn.com.chnsys.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void FindAllUser(){
		List<User> list = userMapper.findAllUser();
		for (User u : list) {
			System.out.println(u.toString());
		}
	}
}
