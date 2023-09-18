package org.sunso.sotheme.springcloud.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunso.keypoint.springboot2.biz.keypoint.distribute.lock.annotation.DistributeLock;
import org.sunso.keypoint.springboot2.biz.keypoint.distribute.lock.executer.DistributeLockExecuter;
import org.sunso.keypoint.springboot2.biz.keypoint.distribute.lock.handler.RedissonDistributeLockHandler;
import org.sunso.keypoint.springboot2.biz.keypoint.distribute.lock.model.DistributeLockModel;
import org.sunso.sotheme.springcloud.order.dto.OrderDTO;
import org.sunso.sotheme.springcloud.order.entity.Order;

@Slf4j
@Service
public class DistributeLockServiceImpl {

    @Autowired
    private RedissonDistributeLockHandler handler;


    @DistributeLock(lockKey = "lock_aspect_${orderId}_${createTime}_${user.userId}_${user.userName}")
    public OrderDTO aspect(OrderDTO order) {
        return order;
    }

    public String methodLock() {
        return (String)handler.handle(DistributeLockModel.newInstance("methodLock"), new DistributeLockExecuter() {
            @Override
            public Object execute() {
                return "test";
            }
        });
    }

    public long getTimeoutLock(long timeout) {
        String lockKey = "lock_timeout_" + timeout;
        DistributeLockModel lockModel = DistributeLockModel.newInstance(lockKey);
        lockModel.setWaitTime(1);
        //handler.handleWithException(lockModel, this::getResult, timeout);
        handler.handleWithException(lockModel, new DistributeLockExecuter() {
            @Override
            public Object execute() {
                getResultVoid(timeout);
                return null;
            }
        });
        return timeout;
    }

    private Void getResult(long timeout) {
        try {
            Thread.sleep(timeout);
            log.info("sleep timeout[{}]" , timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void getResultVoid(long timeout) {
        try {
            Thread.sleep(timeout);
            log.info("sleep timeout[{}]" , timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
