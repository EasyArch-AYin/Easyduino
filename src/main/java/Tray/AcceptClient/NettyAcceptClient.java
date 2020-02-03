package Tray.AcceptClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyAcceptClient {
    public static void main(String[] args) {

        EventLoopGroup workergroup = new NioEventLoopGroup();

        Bootstrap Bootstrap = new Bootstrap();

        Bootstrap.group(workergroup)
                .channel(NioSocketChannel.class)
                .handler(new ClientHandler());

        try {
            ChannelFuture channelFuture = Bootstrap.connect("127.0.0.1", 8088).sync();
            System.out.println("客户端连接成功");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workergroup.shutdownGracefully();
        }

    }
}
