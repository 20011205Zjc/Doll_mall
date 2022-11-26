package com.doll.doll_mall;

import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.service.UserAddressService;
import com.doll.doll_mall.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DollMallApplicationTests {
	@Autowired
	private UserService userService;

	/*测试查询所有的用户*/
	@Test
	void contextLoads() {
		List<User> allUser = userService.getAllUser();
		System.out.println(allUser);
	}

	/*测试用户添加*/
/*
	@Test
	void testInsertUser(){
		User user = new User(null, "里斯", "123456", 12, "女", "432@qq.com", "qaq");
		userService.insertUser(user);
	}
*/

	/*测试搜索联想*/
//	@Test
//	void testGetLikeUsername(){
		/*List<User> likeUsername = userService.getLikeUsername("张");
		for (User user : likeUsername) {
			String userName = user.getUserName();
			System.out.println(userName);
		}
		System.out.println(likeUsername);*/

//	}

/*

	*//*删除用户信息*//*
	@Test
	void delUser(){
		userService.delUser(1);
	}

	*//*根据id查询用户信息*//*
	@Test
	void selUser(){
		List<User> userById = userService.getUserById(2);
		System.out.println(userById);
	}

	*//*动态sql语句实现用户信息的修改*//*
	@Test
	void SQLUpdate(){
		User user = new User(2,null,"123456","2001-12-05","女","4433","");
		userService.updateUserByIf(user);
	}*/

	/*修改用户信息测试*/
/*	@Test
	void testUpdate(){
		User user = new User(1,null,"","2000-12-05","女","315098211","111","admin");
		userService.updateUser(user);
	}*/

/*	@Test
	void SQLUpdate(){
		User user = new User(1,null,"","2001-12-05","女","4433","","admin",null);
		userService.updateUserByIf(user);
	}*/
	@Autowired
	private UserAddressService userAddressService;

	@Test
	void testgetUseraND(){
		System.out.println(userAddressService.getUserAndAddress(4));
	}

}
