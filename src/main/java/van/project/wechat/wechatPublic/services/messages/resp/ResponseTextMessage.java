package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import van.project.wechat.wechatPublic.services.messages.receive.BaseMessage;

@Data
public class ResponseTextMessage extends ResponseBaseMessage {

    public ResponseTextMessage() {
        super();
        msgType = MsgType.text;
    }

    public ResponseTextMessage(BaseMessage baseMessage) {
        super(baseMessage);
        msgType = MsgType.text;
    }

    public ResponseTextMessage(BaseMessage baseMessage, String content) {
        super(baseMessage);
        msgType = MsgType.text;
        this.content = content;
    }

    public static Builder builder(BaseMessage baseMessage) {
        return new Builder(baseMessage);
    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Content")
    private String content;

    public static class Builder {
        private BaseMessage baseMessage;
        private String content;

        public Builder(BaseMessage baseMessage) {
            this.baseMessage = baseMessage;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public ResponseTextMessage build() {
            return new ResponseTextMessage(baseMessage, content);
        }
    }

}
