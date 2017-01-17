package com.zhjg.mybatis.plus.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhjg.mybatis.plus.entity.TUser;
import com.zhjg.mybatis.plus.service.ITUserService;

public class TUserServiceTest {

	private ApplicationContext context;
	private ITUserService service;
	
	@Before
	public void initializeSpring(){
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		service = (ITUserService) context.getBean("TUserServiceImpl");
	}
	
	/**
	 * 基本的增删改查，批量删除、插入
	 */
	
	@Test
	public void testAddUser(){
		TUser user = new TUser();
		user.setUserName("李四");
		user.setUserAge(18);
		service.insert(user);
	}
	
	@Test
	public void testQueryUserById(){
		System.out.println(service.selectById("123").toString());
	}
	
	@Test
	public void testDeleteUserById(){
		service.deleteById("1");
	}
	
	@Test
	public void testUpdateUser(){
		TUser user = service.selectById("123");
		user.setUserAge(24);
		service.updateById(user);
	}
	
	@Test
	public void testGetUserListByEntityWrapper(){
		EntityWrapper<TUser> wrapper = new EntityWrapper<TUser>();
		//wrapper不做修改代表查询所有记录
		//List<TUser> users = service.selectList(wrapper);
		
		//等于
		//wrapper.eq("user_id", 2);
		//List<TUser> users = service.selectList(wrapper);
		
		//通过Map来封装参数进行查询
		// Map params = new HashMap<String, Object>();
		// params.put("user_id", 2);
		// params.put("user_name", "2");
		// params.put("user_age", 2);
		// wrapper.allEq(params);
		// List<TUser> users = service.selectList(wrapper);
		
		//拼接查询条件-->where子句,and子句,or子句，orderby子句,in,like,having,isnotnull isnull.....
		//wrapper.where("user_id = 2", null);
		//wrapper.and("user_name = 2", null);
		//wrapper.or("user_id = 3", null);
		//wrapper.or("user_name = 3", null);
		//升序排列
		//wrapper.orderBy("user_id", true);
		//降序排列
		//wrapper.orderBy("user_id", false);
		//List<TUser> users = service.selectList(wrapper);
		
		
		//wrapper.lt("user_id", 5);//小于
		//wrapper.le("user_id", 5);//小于等于
		//wrapper.gt("user_id", 123);//大于
		//wrapper.ge("user_id", 123);//大于等于
		List<TUser> users = service.selectList(wrapper);
		
		for (TUser tUser : users) {
			System.out.println(tUser.toString());
		}
	}
	
	@Test
	public void testSelectPage(){
		//第一页，每页5条记录
		Page<TUser> page = new Page<TUser>(1, 5);
		EntityWrapper<TUser> wrapper = new EntityWrapper<TUser>();
		wrapper.le("user_id", 100);
		page = service.selectPage(page, wrapper);
		System.out.println(page.toString());
		System.out.println("共有"+page.getTotal()+"条记录");
		System.out.println("当前是第"+page.getCurrent()+"页");
		System.out.println("每页显示"+page.getSize()+"条记录");
		System.out.println("共有"+page.getPages()+"页");
		System.out.println("记录：");
		List<TUser> records = page.getRecords();
		for (TUser tUser : records) {
			System.out.println(tUser.toString());
		}
	}
	
	@Test
	public void testBatchQuery(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		ids.add(4);
		List<TUser> users = service.selectBatchIds(ids);
		for (TUser tUser : users) {
			System.out.println(tUser.toString());
		}
	}
	
}