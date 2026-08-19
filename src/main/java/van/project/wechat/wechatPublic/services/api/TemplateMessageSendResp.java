package van.project.wechat.wechatPublic.services.api;

import lombok.Data;

@Data
public class TemplateMessageSendResp {
    // 消息id
    private Long msgid;
    // 错误码
    private Long errcode;
    // 错误描述
    private String errmsg;
}
