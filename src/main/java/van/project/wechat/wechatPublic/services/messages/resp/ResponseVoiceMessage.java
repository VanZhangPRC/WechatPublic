package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;

@Data
public class ResponseVoiceMessage extends ResponseBaseMessage {

    public ResponseVoiceMessage() {
        super();
        msgType = MsgType.voice;
    }

    public ResponseVoiceMessage(BaseMessage baseMessage) {
        super(baseMessage);
        msgType = MsgType.voice;
    }

    @JacksonXmlProperty(localName = "Voice")
    private Voice voice;

    @Data
    public static class Voice {
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "MediaId")
        private String mediaId;
    }

}
        