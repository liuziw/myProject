package com.zw.service;

import com.zw.domain.Module;
import com.zw.domain.RoleModuleKey;
import com.zw.mapper.ModuleMapper;
import com.zw.mapper.RoleModuleMapper;
import com.zw.mapper.UserMapper;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hcf on 2017/8/31.
 */
@Service
public class ModuleService extends BaseService<Module>{

    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private RoleModuleMapper roleModuleMapper;
    @Autowired
    private UserMapper userMapper;


    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(moduleMapper);
    }

    @Override
    public List<Module> findAll() {
        return moduleMapper.selectAll();
    }

    public List<Module> findMenus(Set<String> permissions, Integer id) {
       // List<Module> allModules = findAll();
        List<Module> allModules = userMapper.findModuleById(id);
        List<Module> menus = new ArrayList<Module>();
        for(Module module : allModules) {
            /*if(resource.isRootNode()) {
                continue;
            }*/
            if(!module.getType().equals("menu")) {
                continue;
            }
            if(!module.getAvailable()){
                continue;
            }
            if(!hasPermission(permissions, module)) {
                continue;
            }
            menus.add(module);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Module module) {
        if(StringUtils.isEmpty(module.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(module.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteById(Integer id){
        List<Module> list = moduleMapper.selectByPid(id);
        if(list!=null&&list.size()>0){
            for(Module m : list){
                deleteById(m.getId());
            }
        }
        roleModuleMapper.deleteByModuleId(id);
        moduleMapper.deleteByPrimaryKey(id);
        return 0;
    }



    public Set<Module> selectModuleByRole(Integer roleId) {
        return roleModuleMapper.selectModuleByRole(roleId);
    }

    public int insertBatch(List<RoleModuleKey> list){
        return roleModuleMapper.insertBatch(list);
    }
}
