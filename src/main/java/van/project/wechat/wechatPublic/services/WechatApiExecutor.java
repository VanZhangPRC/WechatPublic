package van.project.wechat.wechatPublic.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import van.project.wechat.wechatPublic.services.api.TemplateMessageSendReq;
import van.project.wechat.wechatPublic.services.api.TemplateMessageSendReq.DataElement;
import van.project.wechat.wechatPublic.services.api.TemplateMessageSendResp;
import van.project.wechat.wechatPublic.services.api.WechatFeign;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class WechatApiExecutor {

    private IAccessTokenService accessTokenService;
    private WechatFeign wechatFeign;

    /**
     * 发送模版消息
     * @param userOpenId 用户 openid
     * @param templateId 模版消息 ID
     * @param data 模版消息数据
     * @return 发送结果
     */
    public TemplateMessageSendResp sendTemplateMessage(String userOpenId, String templateId, Map<String, DataElement> data) {
        TemplateMessageSendReq req = new TemplateMessageSendReq();
        req.setTouser(userOpenId);
        req.setTemplate_id(templateId);
        req.setData(data);

        log.info("发送模版消息 [id: {}] to userOpenId: {}", templateId, userOpenId);
        TemplateMessageSendResp resp = wechatFeign.templateMessageSend(accessTokenService.getAccessToken(), req);
        if (resp.getErrcode() != 0) {
            log.error("发送模版消息失败：[错误码：{} | 错误信息：{}]，templateId: {}, userOpenId: {}", resp.getErrcode(), resp.getErrmsg(), templateId, userOpenId);
        }
        return resp;
    }

}
