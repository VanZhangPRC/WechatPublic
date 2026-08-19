package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;

@Data
public class ResponseVideoMessage extends ResponseBaseMessage {

    public ResponseVideoMessage() {
        super();
        msgType = MsgType.video;
    }

    public ResponseVideoMessage(BaseMessage baseMessage) {
        super(baseMessage);
        msgType = MsgType.video;
    }

    @JacksonXmlProperty(localName = "Video")
    private Video video;

    @Data
    public static class Video {
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "MediaId")
        private String mediaId;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Title")
        private String title;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Description")
        private String description;
    }

}
        