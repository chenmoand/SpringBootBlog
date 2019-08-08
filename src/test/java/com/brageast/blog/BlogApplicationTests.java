package com.brageast.blog;

import com.brageast.blog.entity.User;
import com.brageast.blog.mapper.GroupMapper;
import com.brageast.blog.mapper.PermissionsMapper;
import com.brageast.blog.service.ArticleService;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.EntityUtil;
import com.brageast.blog.util.JwtUtil;
import com.brageast.blog.util.entity.Combination;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired(required=false)
    private GroupMapper groupMapper;
    @Autowired(required=false)
    private PermissionsMapper permissionsMapper;

    @Test
    public void contextLoads() throws Exception {
        /*new UserJwt();
        String str = PasswordTools.encrypt("adad");
        String strr = PasswordTools.decrypt(str);
        ConfigTools.decrypt(str);
        System.out.println(strr);
        userService.insertUser(10213,"chenmo","213213","2010557767@qq.com","admin","admin");
        userService.getUsers(new Page<>(0,4)).getRecords().forEach(System.out::println);*/

        User u = userService.findUser("阿三打撒");
        System.out.println(u);
//        userService.getUsers(new Page<>(1, 10)).getRecords().forEach(System.out::println);
    }
    @Test
    public void Jsontest(){
        User admin = userService.findUser("chenmo");
        String token = JwtUtil.builder(admin);
        if(admin != null) {
            System.out.println(token);
        }
        Claims body = JwtUtil.getClaims(token);
        System.out.println(body);
    }

    @Test
    public void A(){
        userService.addUser("chenmo","132146","2010557767@qq.com",
                new HashSet<Integer>(){{add(1); add(2);}});
    }

    @Test
    public void B(){
        userService.deleteUser(4);
    }
    @Test
    public void C(){
//        groupMapper.getGroups(new Page<>(1, 5)).getRecords().forEach(System.out::println);
        System.out.println(groupMapper.findGroup(2));
    }
    @Test
    public void E(){

        permissionsMapper.addPermissions(EntityUtil.getEntity("abc","bcd"));
    }

    @Test
    public void H(){
        permissionsMapper.deletePermissions(3);
    }
}
