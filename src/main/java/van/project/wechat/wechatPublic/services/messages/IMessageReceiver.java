package van.project.wechat.wechatPublic.services.messages;

import van.project.wechat.wechatPublic.services.messages.receive.*;
import van.project.wechat.wechatPublic.services.messages.resp.ResponseBaseMessage;

public interface IMessageReceiver {

    ResponseBaseMessage receiveLinkMessage(LinkMessage message);
    ResponseBaseMessage receiveLocationMessage(LocationMessage message);
    ResponseBaseMessage receivePic(PicMessage message);
    ResponseBaseMessage receiveShortVideo(ShortVideoMessage message);
    ResponseBaseMessage receiveText(TextMessage message);
    ResponseBaseMessage receiveVideo(VideoMessage message);
    ResponseBaseMessage receiveVoice(VoiceMessage message);



}
