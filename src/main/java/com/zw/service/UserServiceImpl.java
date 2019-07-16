package com.zw.service;

import com.zw.domain.User;
import com.zw.mapper.UserMapper;
import com.zw.shiro.util.PasswordHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Administrator on 2017/10/9.
 */
@Service
public class UserServiceImpl  extends BaseService<User>{
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordHelper passwordHelper;

    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Integer userId, String newPassword) {
        User user =userMapper.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKeySelective(user);
    }


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        //return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
        return userMapper.findRolesByUserName(username);
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        //return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
        return userMapper.findPermissionsByUserName(username);
    }
}
