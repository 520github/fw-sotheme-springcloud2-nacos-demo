
# 测试@methodCache

## 执行接口
curl http://localhost:9091/cache/order/get/100
curl http://localhost:9091/cache/method/order/caffeine/get/190
curl http://localhost:9091/cache/method/order/guava/get/290

## 查询本地所有缓存key
curl http://localhost:9091/method/cache/keys/local/caffeine/true


## 删除某个缓存key
curl http://localhost:9091/method/cache/remove/redis/caffeine/true/{key}

http://localhost:9091/method/cache/remove/redis/caffeine/true/service_method_cache_order_7dd629def115dc6d40dba44c765d3c3a


## 清空所有本地缓存key
curl http://localhost:9091/method/cache/clear/local/caffeine/true

## 根据key前缀删除分布式缓存
curl http://localhost:9091/method/cache/remove/distribute/redis/service_method_cache_order


# 手动测试多级缓存

## 执行缓存设置接口
http://localhost:9091/cache/set/value/{key}/{value}

## 执行缓存查询接口
http://localhost:9091/cache/get/value/{key}

## 执行缓存清理接口
http://localhost:9091/clear

------------------------------------