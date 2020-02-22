package client.dataClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class DataClientHanler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("我连接到服务器了!",CharsetUtil.UTF_8),new InetSocketAddress("127.0.0.1",8087)));
        System.out.println("消息发送成功");
    }

    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        ByteBuf byteBuf =msg.content();
        System.out.println("服务器发送的消息是： " + byteBuf.toString(CharsetUtil.UTF_8));
    }

}
