package van.project.wechat.wechatPublic;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import van.project.wechat.wechatPublic.common.properties.WechatProperties;
import van.project.wechat.wechatPublic.services.AccessTokenService;
import van.project.wechat.wechatPublic.services.IAccessTokenService;
import van.project.wechat.wechatPublic.services.api.WechatFeign;


@AutoConfigureBefore(JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages = "van.project.wechat.wechatPublic")
@EnableConfigurationProperties(value = {WechatProperties.class})
@EnableFeignClients(basePackages = "van.project.wechat.wechatPublic.services.api")
public class WechatPublicConfiguration {

    @Bean
    @ConditionalOnMissingBean(IAccessTokenService.class)
    public IAccessTokenService accessTokenService(WechatProperties properties, WechatFeign wechatFeign) {
        return new AccessTokenService(properties, wechatFeign);
    }

}

