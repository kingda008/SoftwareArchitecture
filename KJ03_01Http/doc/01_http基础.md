Http请求：他们之间通信是以报文的形式

客户端请求（Request）：请求报文 = 请求头 + 空行 + 请求数据

Accept: 客户端可以处理的数据格式

**Cookie：服务端的之前给我们的Cookie**

服务端响应（Response）：响应报文 = 响应头 + 空行 + 响应数据

Status Code 响应状态码

**Content-Type:  响应返回的类型 （文本，utf-8）图片等等**

**Set-Cookie：服务端给我们的Cookie，要保存起来，下次带过去**



**Cookie 、Session、Token**

1 都是用来做持久化处理的，目的就是让客户端和服务端相互认识。Http请求默认是不持久的没有状态的，谁也不认识谁

2 Cookie: 是存放在客户端的信息，这个信息是来自于服务器返回的信息，

下次请求带过去，如果用户离开网站后，如果Cookie已过期一般是会被清楚的。如果Cookie没过期下次访问网站还是会带过去。（相对危险）

3 Session: 是存放在服务器上面的客户端临时信息，用户离开网站是会被清除的。（相对安全，耗资源）

4 Token（App）"令牌"：用户身份的验证，有点类似于 Cookie  ，相对来说更安全，一般流程：

​	4.1 客户端像服务端申请 Token

​	4.2 服务端收到请求，会去验证用户信息,签发一个 Token 给客户端，自己保存 Token

​	4.3 客户端收到 Token 会保存起来，每次请求带上 Token 

​	4.4 服务器收到其他请求，会去验证客户端的 Token , 如果成功返回数据，不成功啥都不给

**Http缓存**

Cache-Control（缓存策略）：Public、private、no-cache、max-age  、no-store（不缓存）

Expires（缓存的过期策略）：指名了缓存数据有效的绝对时间，告诉客户端到了这个时间点（比照客户端时间点）后本地缓存就作废了，

在这个时间点内客户端可以认为缓存数据有效，可直接从缓存中加载展示。

https://mp.weixin.qq.com/s/qOMO0LIdA47j3RjhbCWUEQ

 

# HTTP状态码：

1xx:  Infomational (信息状态码) ，接收的请求正在处理

2xx:  Succeed(成功)，请求正常处理完毕,如 200

3xx:  Redirection(重定向)，需要进行附加操作，一般是没有响应数据返回的，如 304（Not,modified）307 

4xx: Client Error (客户端的错误)，服务器无法处理请求，如  404

5xx: Server Error (服务端的错误)，服务器处理请求出错，如  500



# Http 和 Https 的区别：

Https = Http + 加密 + 验证 + 完整

端口：Http (80)  Https (443)



# Http 的缺点：

1 数据是没有加密传输，可能遭遇窃听

2 不验证通信方的身份，可能会遭遇伪装

3 无法验证报文的完整性，可能会遭遇篡改



# TLS/SSL 协议：

加密：对称加密（AES，DES） + 非对称加密  (RSA，DSA)

证书：要钱（便宜），建立连接的速度会拖慢，TCP  3 次握手，8 次握手

![对称加密](01_http%E5%9F%BA%E7%A1%80.assets/%E5%AF%B9%E7%A7%B0%E5%8A%A0%E5%AF%86-16664182301933-16664182317134.jpg)



![对称加密](01_http%E5%9F%BA%E7%A1%80.assets/%E9%9D%9E%E5%AF%B9%E7%A7%B0%E5%8A%A0%E5%AF%86-16664182159552.jpg)







# Http 1.x 和 Http 2.0 的区别

1 Http 2.0 采用二进制格式而非文本格式

2 Http 2.0 支持完全的多路复用

3 Http 2.0 使用报头压缩，降低开销

4 Http 2.0  让服务器将响应主动推送给客户端，（带内容推送，不带内容推送的通知）



![Http1.0和Http2.0的区别](01_http%E5%9F%BA%E7%A1%80.assets/Http1.0%E5%92%8CHttp2.0%E7%9A%84%E5%8C%BA%E5%88%AB-16664182703065.png)





