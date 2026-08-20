package van.project.wechat.wechatPublic.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import van.project.wechat.wechatPublic.common.properties.WechatProperties;
import van.project.wechat.wechatPublic.services.api.AccessTokenReq;
import van.project.wechat.wechatPublic.services.api.AccessTokenResp;
import van.project.wechat.wechatPublic.services.api.WechatFeign;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class AccessTokenService implements IAccessTokenService {

    private final WechatProperties wechatProperties;
    private final WechatFeign wechatFeign;

    private volatile String accessToken;
    private volatile LocalDateTime expireAt;
    private final Object lock = new Object();

    @Override
    public String getAccessToken() {

        LocalDateTime now = LocalDateTime.now();
        if (accessToken != null && now.isBefore(expireAt)) {
            return accessToken;
        }

        synchronized (lock) {
            if (accessToken == null || now.isAfter(expireAt)) {
                AccessTokenResp accessTokenResp = wechatFeign.stableToken(new AccessTokenReq(wechatProperties.getAppId(), wechatProperties.getAppSecret()));
                this.accessToken = accessTokenResp.getAccess_token();
                long expiresIn = (accessTokenResp.getExpires_in() == null ? 7200L : accessTokenResp.getExpires_in()) - 1800L;
                this.expireAt = now.plusSeconds(expiresIn);
                log.info("token refreshed, expired in {}", expiresIn);
            }
        }
        return accessToken;
    }
}
