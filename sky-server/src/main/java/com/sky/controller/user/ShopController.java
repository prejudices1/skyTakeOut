package com.sky.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.sky.result.Result;

/**
 * @author Yaoxin Dong
 * @date 2023/09/25 14:47
 **/
@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺接口")
@Slf4j
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;
//    @PutMapping("/{status}")
//    @ApiOperation("设置营业状态")
//    public Result setStation(@PathVariable Integer status){
//        log.info("设置营业状态");
//        redisTemplate.opsForValue().set("SHOP_STATUS",status);
//        return Result.success();
//
//    }
    @GetMapping("/status")
    @ApiOperation("用户获取店铺营业状态")
    public Result<Integer> getStatus(){
        Integer status= (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("{}",status==1?"营业中":"打样");

        return Result.success(status);
    }
}
