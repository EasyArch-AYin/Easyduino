package client.acceptClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Data;

@Data
public class NettyAcceptClient {

        private EventLoopGroup workergroup;
        private Bootstrap Bootstrap;

public void run(String IP,int PORT) {


        workergroup = new NioEventLoopGroup();
        Bootstrap = new Bootstrap();

        Bootstrap.group(workergroup)
                .channel(NioSocketChannel.class)
                .handler(new AcceptClientHandler());

        try {
            ChannelFuture channelFuture = Bootstrap.connect(IP,PORT).sync();
            System.out.println("客户端连接成功");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workergroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        NettyAcceptClient Accept = new NettyAcceptClient();
        Accept.run("127.0.0.1", 8088);
    }
}
