package van.project.wechat.wechatPublic.common.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("wechat-public.wechat")
public class WechatProperties {

    private String appId;
    private String appSecret;
    private String token;
    private String openId;
}
