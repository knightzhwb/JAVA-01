package simulate;


import simulate.inbound.HttpInboundServer;

import java.util.Arrays;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/1/26
 */
public class SimulateApplication {
    
    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "3.0.0";
    
    public static void main(String[] args) {
        //gateway1.0
//        String proxyServers = System.getProperty("proxyServer","http://localhost:8803");
        //gateway3.0
        String proxyServer = System.getProperty("proxyServer","http://localhost:8801,http://localhost:8802,http://localhost:8803");
        String[] list  = proxyServer.split(",");
        String proxyPort = System.getProperty("proxyPort","8888");
        
          //  http://localhost:8888/api/hello  ==> gateway API
          //  http://localhost:8088/api/hello  ==> backend service
    
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(list));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
