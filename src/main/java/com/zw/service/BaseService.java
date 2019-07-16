package com.zw.service;

import com.zw.mapper.BaseMapper;
import com.zw.util.DataList;
import com.zw.util.Pager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseService<T extends Serializable>{
	@Autowired
    private BaseMapper<T> baseMapper;
  public void setBaseMapper(BaseMapper<T> baseMapper) {
    this.baseMapper = baseMapper;
  }
  public int deleteById(Integer id) {
    return baseMapper.deleteByPrimaryKey(id);
  }
  public T findById(Integer id) {
    return baseMapper.selectByPrimaryKey(id);
  }
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}
	public T selectByPrimaryKey(Integer id) {
		return baseMapper.selectByPrimaryKey(id);
	}
  public int updateByIdSelective(T record) {
    return baseMapper.updateByPrimaryKeySelective(record);
  }
  public int updateByIdWithBLOBs(T record) {
    return baseMapper.updateByPrimaryKeyWithBLOBs(record);
  }
  public int update(T record) {
    return baseMapper.updateByPrimaryKey(record);
  }
  public int save(T record) {
    return baseMapper.insert(record);
  }
  public void deleteBatch(List<Integer> idsList){
	  baseMapper.deleteBatch(idsList);
  }
	
	public DataList selectByPager(Pager pager, Map<String,Object> map) {
		return selectByPager(pager,map,null);
	}

	public DataList selectByPager(Pager pager, Map<String,Object> map, String orderBy) {
		if(pager!=null){
			if (orderBy!=null){
				PageHelper.orderBy(orderBy);
			}
			PageHelper.startPage(pager.getCurrentPage(), pager.getPageSize());
		}
		List<T> list = baseMapper.selectByPager(map);
		PageInfo<T> pi = new PageInfo<T>(list);
		if(pager!=null){
			pager.setTotalSize(pi.getTotal());
			pager.setTotalPage(pi.getPages());
			pager.setCurrentPage(pi.getPageNum()+"");
		}
		return new DataList(pager,list);
	}
	
	public List<T> findAll() {
		List<T> list = baseMapper.selectAll();
		return list;
	}

}