package van.project.wechat.wechatPublic;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({WechatPublicConfiguration.class})
public @interface EnableWechatPublic {
}
