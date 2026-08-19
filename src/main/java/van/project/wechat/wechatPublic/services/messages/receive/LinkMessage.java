package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class LinkMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "Title")
    @JsonProperty("Title")
    private String title;
    @JacksonXmlProperty(localName = "Description")
    @JsonProperty("Description")
    private String description;
    @JacksonXmlProperty(localName = "Url")
    @JsonProperty("Url")
    private String url;
}
