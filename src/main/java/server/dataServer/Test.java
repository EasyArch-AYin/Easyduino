package server.dataServer;

public class Test {
    public static void main(String[] args) {
        NettyDataServer DataServer = new NettyDataServer();
        //测试面板启动
        new TestServerData().view(DataServer);
        //nettyUDP服务器启动
        DataServer.run();
    }
}
