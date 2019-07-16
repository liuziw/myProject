package com.zw.mapper;


import com.zw.domain.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper extends BaseMapper<Shop> {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer id);

    List<Shop> selectShop();

    List<String> selectName();

    List<String> selectNum();

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}