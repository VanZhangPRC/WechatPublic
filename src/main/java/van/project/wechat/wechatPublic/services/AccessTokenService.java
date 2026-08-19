package van.project.wechat.wechatPublic.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import van.project.wechat.wechatPublic.common.properties.WechatProperties;
import van.project.wechat.wechatPublic.services.api.AccessTokenReq;
import van.project.wechat.wechatPublic.services.api.AccessTokenResp;
import van.project.wechat.wechatPublic.services.api.WechatFeign;

@Slf4j
@RequiredArgsConstructor
public class AccessTokenService implements IAccessTokenService {

    protected final WechatProperties wechatProperties;
    protected final WechatFeign wechatFeign;

    protected volatile String accessToken;
    protected volatile Long expireAt;

    @Override
    public synchronized String getAccessToken() {
        long now = System.currentTimeMillis();
        if (accessToken == null || now > expireAt) {
            AccessTokenResp accessTokenResp = wechatFeign.stableToken(new AccessTokenReq(wechatProperties.getAppId(), wechatProperties.getAppSecret()));
            this.accessToken = accessTokenResp.getAccess_token();
            long expiresIn = (accessTokenResp.getExpires_in() == null ? 7200L : accessTokenResp.getExpires_in()) - 1800L;
            this.expireAt = now + expiresIn;
            log.info("token refreshed, expired in {}", expiresIn);
        }
        return accessToken;
    }
}
