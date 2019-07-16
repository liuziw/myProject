package com.zw.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2018/12/20 21:03
 */
public class GpsHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("RamoteAddress : " + channelHandlerContext.channel().remoteAddress() + " active !");
        System.out.println(s);
//        channelHandlerContext.channel().writeAndFlush("from server；" + LocalDateTime.now());

    }

      /**
      * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
      *
      * */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // 当出现异常就关闭连接
        ctx.close();
    }
}
