基于Apache Mina实现的TCP长连接和短连接实例 

整个系统由两个服务端程序和两个客户端程序组成。分别实现TCP长连接和短连接通信。
系统业务逻辑是一个客户端与服务端建立长连接，一个客户端与服务端建立短连接。
数据从短连接客户端经过服务端发送到长连接客户端，并从长连接客户端接收响应数据。
当收到响应数据后断开连接。

详细说明，可参见blog http://blog.csdn.net/peterwanghao/article/details/6900523

运行过程：
1、运行 Main.java，启动服务端。
2、运行TcpKeepAliveClient.java，启动长连接客户端。
3、运行MinaShortClient.java，启动短连接客户端。

