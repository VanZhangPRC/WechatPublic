package van.project.wechat.wechatPublic.services.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wechatFeign", url = "https://api.weixin.qq.com/cgi-bin")
public interface WechatFeign {

    @PostMapping(path = "/stable_token")
    AccessTokenResp stableToken(@RequestBody AccessTokenReq accessTokenReq);

    @PostMapping(path = "/message/template/send")
    TemplateMessageSendResp templateMessageSend(@RequestParam("access_token") String accessToken, @RequestBody TemplateMessageSendReq request);

}
