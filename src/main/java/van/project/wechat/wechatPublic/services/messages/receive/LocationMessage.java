package van.project.wechat.wechatPublic.services.messages.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class LocationMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "Location_X")
    @JsonProperty("Location_X")
    private String location_X;
    @JacksonXmlProperty(localName = "Location_Y")
    @JsonProperty("Location_Y")
    private String location_Y;
    @JacksonXmlProperty(localName = "Scale")
    @JsonProperty("Scale")
    private String scale;
    @JacksonXmlProperty(localName = "Label")
    @JsonProperty("Label")
    private String label;
}
