package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author Yaoxin Dong
 * @date 2023/10/07 20:40
 **/
@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     */

    void insertBatch(List<DishFlavor> flavors);

}
