import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import van.project.wechat.wechatPublic.services.WechatApiExecutor;
import van.project.wechat.wechatPublic.services.api.TemplateMessageSendReq.DataElement;
import van.project.wechat.wechatPublic.services.api.TemplateMessageSendResp;

import java.time.LocalDate;
import java.util.HashMap;

@SpringBootTest(classes = TestApplication.class)
public class 测试模板消息 {

    @Autowired
    private WechatApiExecutor executor;

    @Test
    @DisplayName("发送模版消息")
    public void test() {

        HashMap<String, DataElement> data = new HashMap<>();
        data.put("eventTime", new DataElement(LocalDate.now()));
        data.put("event", new DataElement("停车场相关事项"));

        TemplateMessageSendResp resp = executor.sendTemplateMessage(
                "oCdDY14-mL0Xab0KpADxtleiW44E",
                "bnDl2Gnssulz21Opa1zPawCJi6S5WDF91k6F8E-DZKE",
                data
        );

        Assertions.assertEquals(0, resp.getErrcode());
    }

}
