package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class TextMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "Content")
    @JsonProperty("Content")
    private String content;

}
