package com.zw.mapper;

import com.zw.domain.Module;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleMapper extends BaseMapper<Module>{
    public int deleteByPrimaryKey(Integer id);

    public int insert(Module record);

    public int insertSelective(Module record);

    public Module selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Module record);

    public int updateByPrimaryKey(Module record);

    @Select("select * from sys_module where pid = #{id}")
    public List<Module> selectByPid(Integer id);
}