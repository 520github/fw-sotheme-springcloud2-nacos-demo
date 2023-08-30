
## 直接通过orderService访问
~~~
curl http://localhost:9091/order/get/105
~~~

## 直接通过userService访问
~~~
curl http://localhost:9092/user/get/1692078242128965633
~~~

## 通过gateway访问order和user服务
~~~
访问orderService服务：
curl http://localhost:9090/orderService/order/get/105

访问userService服务：
curl http://localhost:9090/userService/user/get/1692078242128965633
~~~