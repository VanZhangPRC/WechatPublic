package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class PicMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "PicUrl")
    @JsonProperty("PicUrl")
    private String picUrl;
    @JacksonXmlProperty(localName = "MediaId")
    @JsonProperty("MediaId")
    private String mediaId;

}
