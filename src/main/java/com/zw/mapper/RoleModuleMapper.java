package com.zw.mapper;

import com.zw.domain.Module;
import com.zw.domain.RoleModuleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleModuleMapper extends BaseMapper<RoleModuleKey> {
    int deleteByPrimaryKey(RoleModuleKey key);

    int insert(RoleModuleKey record);

    int insertSelective(RoleModuleKey record);

    int insertBatch(List<RoleModuleKey> list);

    @Select("select tsm.* from sys_module tsm right join sys_role_module tsrm on tsm.id = tsrm.moduleid where tsrm.roleid =  #{id} order by tsm.level ")
    Set<Module> selectModuleByRole(Integer id);

    @Delete("delete from sys_role_module where moduleid = #{id}")
    void deleteByModuleId(Integer id);

    void deleteRoleModuleSelective(RoleModuleKey rM);

    @Delete("delete from sys_role_module where roleid = #{id}")
    void deleteByRoleId(Integer id);
}