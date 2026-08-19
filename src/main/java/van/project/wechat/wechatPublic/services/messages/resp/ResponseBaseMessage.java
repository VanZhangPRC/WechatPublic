package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;

@Data
@JsonRootName("xml")
public class ResponseBaseMessage {

    public ResponseBaseMessage() {
        createTime = System.currentTimeMillis() / 1000;
    }

    public ResponseBaseMessage(BaseMessage baseMessage) {
        this();
        this.toUserName = baseMessage.getFromUserName();
        this.fromUserName = baseMessage.getToUserName();
    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "ToUserName")
    protected String toUserName;
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "FromUserName")
    protected String fromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    protected Long createTime;
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "MsgType")
    protected MsgType msgType;

    public enum MsgType {
        text, image, voice, video, music, news;
    }

}
