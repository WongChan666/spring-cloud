package com.meinergy.springcloud.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meinergy.springcloud.commons.entity.User;
import com.meinergy.springcloud.payment.mapper.UserMapper;
import com.meinergy.springcloud.payment.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WongChan
 * @since 2020-07-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
