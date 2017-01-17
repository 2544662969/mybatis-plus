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
	 * ��������ɾ�Ĳ飬����ɾ��������
	 */
	
	@Test
	public void testAddUser(){
		TUser user = new TUser();
		user.setUserName("����");
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
		//wrapper�����޸Ĵ����ѯ���м�¼
		//List<TUser> users = service.selectList(wrapper);
		
		//����
		//wrapper.eq("user_id", 2);
		//List<TUser> users = service.selectList(wrapper);
		
		//ͨ��Map����װ�������в�ѯ
		// Map params = new HashMap<String, Object>();
		// params.put("user_id", 2);
		// params.put("user_name", "2");
		// params.put("user_age", 2);
		// wrapper.allEq(params);
		// List<TUser> users = service.selectList(wrapper);
		
		//ƴ�Ӳ�ѯ����-->where�Ӿ�,and�Ӿ�,or�Ӿ䣬orderby�Ӿ�,in,like,having,isnotnull isnull.....
		//wrapper.where("user_id = 2", null);
		//wrapper.and("user_name = 2", null);
		//wrapper.or("user_id = 3", null);
		//wrapper.or("user_name = 3", null);
		//��������
		//wrapper.orderBy("user_id", true);
		//��������
		//wrapper.orderBy("user_id", false);
		//List<TUser> users = service.selectList(wrapper);
		
		
		//wrapper.lt("user_id", 5);//С��
		//wrapper.le("user_id", 5);//С�ڵ���
		//wrapper.gt("user_id", 123);//����
		//wrapper.ge("user_id", 123);//���ڵ���
		List<TUser> users = service.selectList(wrapper);
		
		for (TUser tUser : users) {
			System.out.println(tUser.toString());
		}
	}
	
	@Test
	public void testSelectPage(){
		//��һҳ��ÿҳ5����¼
		Page<TUser> page = new Page<TUser>(1, 5);
		EntityWrapper<TUser> wrapper = new EntityWrapper<TUser>();
		wrapper.le("user_id", 100);
		page = service.selectPage(page, wrapper);
		System.out.println(page.toString());
		System.out.println("����"+page.getTotal()+"����¼");
		System.out.println("��ǰ�ǵ�"+page.getCurrent()+"ҳ");
		System.out.println("ÿҳ��ʾ"+page.getSize()+"����¼");
		System.out.println("����"+page.getPages()+"ҳ");
		System.out.println("��¼��");
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