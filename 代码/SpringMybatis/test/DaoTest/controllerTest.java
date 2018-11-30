package DaoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xd.po.User;
import cn.xd.service.UserService;

public class controllerTest {
	@Autowired
	private UserService userService;
	@Test
	public void findUserByid()throws Exception{
		User user =userService.findUserById("3");
		
		System.err.println(user);
	}
}
