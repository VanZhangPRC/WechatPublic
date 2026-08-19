package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class VoiceMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "MediaId")
    @JsonProperty("MediaId")
    private String mediaId;
    @JacksonXmlProperty(localName = "Format")
    @JsonProperty("Format")
    private String format;
}
