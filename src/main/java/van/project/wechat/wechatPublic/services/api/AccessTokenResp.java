package van.project.wechat.wechatPublic.services.api;

import lombok.Data;

@Data
public class AccessTokenResp {

    private String access_token;
    private Long expires_in;

}
