package org.sunso.sotheme.springcloud.order.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sunso.sotheme.springcloud.order.base.CommonMapper;
import org.sunso.sotheme.springcloud.order.entity.Order;

public interface OrderMapper extends CommonMapper<Order> {

    @Select("select * from t_order_0 where order_id=#{orderId}")
    Order getOneByOrderId(@Param("orderId") Long orderId);
}
