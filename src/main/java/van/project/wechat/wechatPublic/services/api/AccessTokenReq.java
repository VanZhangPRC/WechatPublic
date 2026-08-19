package van.project.wechat.wechatPublic.services.api;

import lombok.Data;

@Data
public class AccessTokenReq {

    private String grant_type = "client_credential";
    private String appid;
    private String secret;

    public AccessTokenReq(String appid, String secret) {
        this.appid = appid;
        this.secret = secret;
    }
}
