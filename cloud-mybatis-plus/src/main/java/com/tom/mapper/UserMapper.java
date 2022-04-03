package com.tom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.entity.User;
import com.tom.entity.UserIdentifyInfo;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {


    List<UserIdentifyInfo> getUserIdentifyInfo();
}

