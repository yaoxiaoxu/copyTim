
package com.yaoxx.base.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**

* Filename:    WebSocketConfig.java

* @version:     1.0
* @since:       JDK 1.8.0_91
* @Description:
*
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description<br>
* ------------------------------------------------------------------<br>

* 2018年11月9日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@Configuration
public class WebSocketConfig {
	

	@Bean("serverEndpointExporter")  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    }  

}
