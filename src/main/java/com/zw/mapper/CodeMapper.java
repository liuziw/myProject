package com.zw.mapper;

import com.zw.domain.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/4/28 16:14
 */
@Repository
public interface CodeMapper {

    List<Code> listCode();

}
