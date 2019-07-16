package com.zw.service;

import com.zw.domain.Shop;
import com.zw.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShopService extends BaseService<Shop>{
    @Autowired
    private ShopMapper shopMapper;

    public List<Shop> selectShop(){
        return shopMapper.selectShop();
    }

    public List<String> selectName(){
        return  shopMapper.selectName();
    }

    public List<String> selectNum(){
        return  shopMapper.selectNum();
    }
}
