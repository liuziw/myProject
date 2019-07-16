package com.zw.mapper;

import com.zw.domain.Module;
import com.zw.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserMapper extends BaseMapper<User>{
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUsername(String username);

    @Select("select sr.role from sys_user su left join sys_user_role sur on su.id = sur.userid left join sys_role sr on sur.roleid = sr.id where su.username = #{username}")
    Set<String> findRolesByUserName(String username);

    @Select("select sm.permission from sys_user su left join sys_user_role sur on su.id = sur.userid left join sys_role sr on sur.roleid = sr.id left join sys_role_module srm on sur.roleid = srm.roleid left join sys_module sm on srm.moduleid = sm.id where sm.permission !='' and sm.available=1 and sr.available=1 and su.username = #{username}")
    Set<String> findPermissionsByUserName(String username);

    @Select("select sm.* from sys_user su left join sys_user_role sur on su.id = sur.userid left join sys_role_module srm on sur.roleid = srm.roleid left join sys_module sm on srm.moduleid = sm.id where sm.available = 1 and su.id = #{id}")
    List<Module> findModuleById(Integer id);
}