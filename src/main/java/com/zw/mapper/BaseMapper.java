package com.zw.mapper;



import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public interface BaseMapper<T extends Serializable> {
  int deleteByPrimaryKey(Integer id);
  int insert(T record);
  int insertSelective(T record);
  T selectByPrimaryKey(Integer id);
  int updateByPrimaryKeySelective(T record);

  int updateByPrimaryKeyWithBLOBs(T record);
  int updateByPrimaryKey(T record);
  List<T> selectByPager(Map<String, Object> map);
  List<T> selectAll();

  void deleteBatch(List<Integer> idsList);

}