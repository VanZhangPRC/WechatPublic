package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class VideoMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "MediaId")
    @JsonProperty("MediaId")
    private String mediaId;
    @JacksonXmlProperty(localName = "ThumbMediaId")
    @JsonProperty("ThumbMediaId")
    private String thumbMediaId;
}
