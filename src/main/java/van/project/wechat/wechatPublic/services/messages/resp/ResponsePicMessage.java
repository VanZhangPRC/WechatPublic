package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;

@Data
public class ResponsePicMessage extends ResponseBaseMessage {

    public ResponsePicMessage() {
        super();
        msgType = MsgType.image;
    }

    public ResponsePicMessage(BaseMessage baseMessage) {
        super(baseMessage);
        msgType = MsgType.image;
    }

    @JacksonXmlProperty(localName = "Image")
    private Image image;

    @Data
    public static class Image {
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "MediaId")
        private String mediaId;
    }

}