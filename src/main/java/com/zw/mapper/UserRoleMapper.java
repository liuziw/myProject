package com.zw.mapper;

import com.zw.domain.UserRoleKey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper extends BaseMapper<UserRoleKey>{
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    void deleteUserRoleSelective(UserRoleKey userRole);
}