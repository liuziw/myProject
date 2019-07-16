package com.zw.netty.HttpClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/3/30 16:48
 */
public class HttpClientInboundHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpResponse)
         {
             HttpResponse response = (HttpResponse) msg;
             System.out.println("CONTENT_TYPE:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE));
         }
         if(msg instanceof HttpContent)
         {
             HttpContent content = (HttpContent)msg;
             ByteBuf buf = content.content();
             System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
             buf.release();
         }
    }
}
