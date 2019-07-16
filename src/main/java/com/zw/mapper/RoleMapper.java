package com.zw.mapper;

import com.zw.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by hcf on 2017/8/11.
 */
@Repository
public interface RoleMapper extends BaseMapper<Role>{

    @Select("select * from sys_role where role = #{roleName}")
    Role selectByName(String roleName);
}
