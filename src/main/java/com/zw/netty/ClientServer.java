package com.zw.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2018/12/21 9:49
 */
public class ClientServer {

    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyClientInitializer());

        try {
            ChannelFuture channelFuture = bootstrap.connect("localhost", 9005).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
