package com.zw.service;

import com.zw.domain.Role;
import com.zw.domain.RoleModuleKey;
import com.zw.domain.UserRoleKey;
import com.zw.mapper.RoleMapper;
import com.zw.mapper.RoleModuleMapper;
import com.zw.mapper.UserRoleMapper;
import com.zw.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService extends BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleModuleMapper roleModuleMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(roleMapper);
    }

    public void saveRole(String moduleIds,Role role){
        role.setAvailable(Boolean.TRUE);
        roleMapper.insertSelective(role);
        this.batchInsert(role,moduleIds);
    }

    /**
     * 通过角色Id删除角色 且删除所用绑定了该角色的用户信息及其该角色拥有的权限信息
     * @param roleId
     */
    public void deleteRoleAndRelation(Integer roleId){
        roleMapper.deleteByPrimaryKey(roleId);
        roleModuleMapper.deleteRoleModuleSelective(new RoleModuleKey(roleId));
        userRoleMapper.deleteUserRoleSelective(new UserRoleKey(roleId));
    }

    public void updateRole(String moduleIds,Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
        roleModuleMapper.deleteByRoleId(role.getId());
        this.batchInsert(role,moduleIds);
    }

    private void batchInsert(Role role, String moduleIds) {
        if (moduleIds !=null && !StringUtils.isEmpty(moduleIds)){
            String[] moduleIdList = moduleIds.split(",");
            List<RoleModuleKey> rMList = new ArrayList<RoleModuleKey>();
            for (String moduleId :moduleIdList){
                RoleModuleKey rM = new RoleModuleKey();
                rM.setRoleid(role.getId());
                rM.setModuleid(Integer.valueOf(moduleId));
                rMList.add(rM);
            }
            // 批量保存新角色对应的权限关系
            roleModuleMapper.insertBatch(rMList);
        }
    }

    public Role selectByName(String roleName) {
        return roleMapper.selectByName(roleName);
    }
}
