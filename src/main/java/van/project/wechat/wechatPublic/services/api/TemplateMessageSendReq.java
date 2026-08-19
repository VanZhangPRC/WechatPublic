package van.project.wechat.wechatPublic.services.api;

import lombok.Data;

import java.util.Map;

@Data
public class TemplateMessageSendReq {
    // 接收者（用户）的 openid
    private String touser;
    // 所需下发的订阅模板id
    private String template_id;
    // 模板跳转链接（海外账号没有跳转能力,url 和 miniprogram 同时不填，无跳转，url 和 miniprogram 同时填写，优先跳转小程序）
    private String url;
    // 跳转小程序时填写（url 和 miniprogram 同时不填，无跳转，page 和 miniprogram 同时填写，优先跳转小程序）
    private Object miniprogram;
    // 模板内容，需根据模板给定的格式给出（参考注意事项），格式形如 { "key1": { "value": any }, "key2": { "value": any } }
    private Map<String, DataElement> data;
    // 防重入id。对于同一个openid + client_msg_id, 只发送一条消息,10分钟有效,超过10分钟不保证效果。若无防重入需求，可不填
    private String client_msg_id;

    @Data
    public static class DataElement {
        private Object value;

        public DataElement(Object value) {
            this.value = value;
        }
    }
}
