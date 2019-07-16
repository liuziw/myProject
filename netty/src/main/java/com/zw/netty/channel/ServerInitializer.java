package com.zw.netty.channel;

import com.zw.netty.handler.GpsHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.*;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2018/12/20 20:55
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
     protected void initChannel(SocketChannel ch) throws Exception {

         ChannelPipeline pipeline = ch.pipeline();

         // 以("\n")为结尾分割的 解码器
//         pipeline.addLast("lenth",new FixedLengthFrameDecoder(7));
//         pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//        pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Unpooled.wrappedBuffer(new byte[] { '#' })));
//        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
//        pipeline.addLast(new LengthFieldPrepender(4));

         // 字符串解码 和 编码
         pipeline.addLast("decoder", new StringDecoder());
         pipeline.addLast("encoder", new StringEncoder());

         // 自己的逻辑Handler
         pipeline.addLast("handler", new GpsHandler());
    }
}
