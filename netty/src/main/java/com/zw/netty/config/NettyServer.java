package com.zw.netty.config;

import com.zw.netty.channel.ServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2018/12/20 20:39
 */
public class NettyServer {

    private final int port;

    public NettyServer(Integer port){
        this.port = port;
    }

    public void startServer(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup);
            b.channel(NioServerSocketChannel.class);
            b.option(ChannelOption.TCP_NODELAY, true);
            b.childHandler(new ServerInitializer());
            b.handler(new LoggingHandler(LogLevel.INFO));
            b.childOption(ChannelOption.AUTO_READ, true);

            // 服务器绑定端口监听
            ChannelFuture f = b.bind(port).sync();

            // 监听服务器关闭监听
            f.channel().closeFuture().sync();

        }catch (InterruptedException e){

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String [] args){
        new NettyServer(8081).startServer();
    }
}
