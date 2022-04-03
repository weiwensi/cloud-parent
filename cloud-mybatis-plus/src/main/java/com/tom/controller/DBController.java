package com.tom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tom.entity.User;
import com.tom.entity.UserIdentifyInfo;
import com.tom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DBController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/list")
    public ResponseEntity<List<User>> getUserList() {
        List<User> users = userMapper.selectList(null);

        List<User> usersBatch = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(usersBatch);
        User user = userMapper.selectById(1);
        System.out.println("单个id查询：" + user);
        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("name", "Jack");
        paramMap.put("age", 20);
        //todo 查询条件的顺讯问题 会不会导致索引失效 不按照最左前缀原则
        List<User> userByMap = userMapper.selectByMap(paramMap);
        System.out.println("通过map的条件查询： " + userByMap);
        QueryWrapper wrapper = new QueryWrapper();
        //like 或者likeleft 或者likeRight 分别代表模糊查询%的位置 默认like为左右都有
        wrapper.likeLeft("name","J");
        User wrapperUser = userMapper.selectOne(wrapper);
        System.out.println("通过wrapper查询结果： "+wrapperUser);
        //分页查询
        Integer count = userMapper.selectCount(null);
        Page<User> page=new Page<User>(2,2);

        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println("分页查询的结果："+userIPage.getRecords()+"总数："+userIPage.getTotal());
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        System.out.println("selectMapPage查询结果: "+mapIPage.isSearchCount()+mapIPage.getRecords());

        List<UserIdentifyInfo> userIdentifyInfo = userMapper.getUserIdentifyInfo();
        System.out.println("用户的身份信息： "+userIdentifyInfo);
        return ResponseEntity.ok(users);
    }
}
