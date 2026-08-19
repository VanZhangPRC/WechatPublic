package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;

@Data
public class ResponseMusicMessage extends ResponseBaseMessage {

    public ResponseMusicMessage() {
        super();
        msgType = MsgType.music;
    }

    public ResponseMusicMessage(BaseMessage baseMessage) {
        super(baseMessage);
        msgType = MsgType.music;
    }

    @JacksonXmlProperty(localName = "Music")
    private Music music;

    @Data
    public static class Music {
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Title")
        private String title;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Description")
        private String description;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "MusicUrl")
        private String musicUrl;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "HQMusicUrl")
        private String hQMusicUrl;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "ThumbMediaId")
        private String thumbMediaId;
    }

}
        