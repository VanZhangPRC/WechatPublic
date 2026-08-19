package van.project.wechat.wechatPublic.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import van.project.wechat.wechatPublic.common.properties.WechatProperties;
import van.project.wechat.wechatPublic.common.utils.SignatureUtil;
import van.project.wechat.wechatPublic.services.messages.MessageReceiveService;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage.MessageType;
import van.project.wechat.wechatPublic.services.messages.resp.ResponseBaseMessage;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/wechat")
@AllArgsConstructor
public class WechatController {


    private WechatProperties wechatProperties;
    private ObjectMapper objectMapper;
    private MessageReceiveService messageReceiveService;

    @RequestMapping(consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    public Object checkin(@RequestParam String signature,
                          @RequestParam String timestamp,
                          @RequestParam String nonce,
                          @RequestParam(required = false) String echostr,
                          @RequestBody(required = false) JsonNode message) {

        if (!SignatureUtil.checkSignature(signature, timestamp, nonce, wechatProperties.getToken())) {
            return null;
        }

        if (echostr != null) {
            log.debug("[微信接口] 收到微信接入请求");
            return echostr;
        }

        JsonNode node = message.get("MsgType");
        if (node != null) {
            MessageType messageType = MessageType.valueOf(node.asText());
            log.debug("[微信接口]接受到普通消息(类型：{})：{}", messageType.name(), message);
            BaseMessage coveredMessage = objectMapper.convertValue(message, messageType.getClazz());
            ResponseBaseMessage receive = messageReceiveService.receive(coveredMessage);
            return receive == null ? "" : receive;
        }

        return null;
    }

    @GetMapping("/test")
    public Object checkinTest() {
        return LocalDateTime.now();
    }
}
