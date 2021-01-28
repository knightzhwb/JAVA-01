package simulate.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simulate.filter.HeaderHttpRequestFilter;
import simulate.outbound.HttpOutboundHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/1/26
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
//
//    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
//    private final List<String> proxyServer;
//    private HttpOutboundHandler handler;
//    private HeaderHttpRequestFilter filter = new HeaderHttpRequestFilter();
//
//    public HttpInboundHandler(List<String> proxyServer) {
//        this.proxyServer = proxyServer;
//        this.handler = new HttpOutboundHandler(this.proxyServer);
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) {
//        ctx.flush();
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
//        try {
//            long startTime = System.currentTimeMillis();
//            logger.info("channelRead流量接口请求开始，时间为{}", startTime);
//            FullHttpRequest fullRequest = (FullHttpRequest) msg;
//            handler.handle(fullRequest, ctx);
//
//            handler.handle(fullRequest, ctx, filter);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
//    }
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private HttpOutboundHandler handler;
    public HttpInboundHandler(List<String> proxyServer) {
        handler = new HttpOutboundHandler(proxyServer);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            logger.info("channelRead流量接口请求开始，时间为{}", df.format(new Date()));
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

}
