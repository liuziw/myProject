package com.zw.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/3/30 16:21
 */
public class HttpServerInboundHandler extends SimpleChannelInboundHandler<Object> {

    private HttpRequest request;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
             request = (HttpRequest) msg;

             String uri = request.getUri();
             System.out.println("Uri:" + uri);
             if(uri.contains("zw")){
                 reply(ctx);
             }
         }
         if (msg instanceof HttpContent) {
             HttpContent content = (HttpContent) msg;
             ByteBuf buf = content.content();
             System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
             buf.release();

             //回应http请求
             String res = "I am OK";
             FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                             OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
             response.headers().set(CONTENT_TYPE, "text/plain");
             response.headers().set(CONTENT_LENGTH,
                             response.content().readableBytes());
             if (HttpHeaders.isKeepAlive(request)) {
                     response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
                 }
             ctx.write(response);
             ctx.flush();
         }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception{
        cause.printStackTrace();
        ctx.close();
    }

    private void reply(ChannelHandlerContext ctx) throws Exception{
        //回应http请求
        String res = "I love you";
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
        response.headers().set(CONTENT_TYPE, "text/plain");
        response.headers().set(CONTENT_LENGTH,
                response.content().readableBytes());
        if (HttpHeaders.isKeepAlive(request)) {
            response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }
        ctx.write(response);
        ctx.flush();
    }
}
