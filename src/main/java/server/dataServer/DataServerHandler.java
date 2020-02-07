package server.dataServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.net.InetAddress;

public class DataServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        //获取客户端发来的信息
        ByteBuf byteBuf = msg.content();
        //获取客户端IP和端口
        InetAddress address = msg.sender().getAddress();
        int port = msg.sender().getPort();
        //打印客户端发来的信息
        System.out.println(address +","+ port);
        System.out.println("客户端信息：" + byteBuf.toString(CharsetUtil.UTF_8));
        //回复信息
        ctx.channel().writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("服务器接收到了你的消息",CharsetUtil.UTF_8),msg.sender()));

    }
}
