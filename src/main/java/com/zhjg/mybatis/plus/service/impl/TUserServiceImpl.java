package com.zhjg.mybatis.plus.service.impl;

import com.zhjg.mybatis.plus.entity.TUser;
import com.zhjg.mybatis.plus.mapper.TUserMapper;
import com.zhjg.mybatis.plus.service.ITUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhjg
 * @since 2017-01-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
	
}
