package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import van.project.wechat.wechatPublic.services.messages.resp.ResponseBaseMessage;

@Data
@JacksonXmlRootElement(localName = "xml")
public class BaseMessage {

    @JacksonXmlProperty(localName = "ToUserName")
    @JsonProperty("ToUserName")
    protected String toUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    @JsonProperty("FromUserName")
    protected String fromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    @JsonProperty("CreateTime")
    protected Long createTime;
    @JacksonXmlProperty(localName = "MsgType")
    @JsonProperty("MsgType")
    protected MessageType msgType;
    @JacksonXmlProperty(localName = "MsgId")
    @JsonProperty("MsgId")
    protected Long msgId;
    @JacksonXmlProperty(localName = "MsgDataId")
    @JsonProperty("MsgDataId")
    protected String msgDataId;
    @JacksonXmlProperty(localName = "Idx")
    @JsonProperty("Idx")
    protected Long idx;

    @Getter
    @AllArgsConstructor
    public enum MessageType {
        text(TextMessage.class),
        image(PicMessage.class),
        voice(VoiceMessage.class),
        video(VideoMessage.class),
        shortvideo(ShortVideoMessage.class),
        location(LocationMessage.class),
        link(LinkMessage.class);

        private Class<? extends BaseMessage> clazz;
    }
}
