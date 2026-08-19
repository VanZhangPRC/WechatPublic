package van.project.wechat.wechatPublic.services.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import van.project.wechat.wechatPublic.services.messages.receive.*;
import van.project.wechat.wechatPublic.services.messages.resp.ResponseBaseMessage;


@Service
public class MessageReceiveService {

    private final IMessageReceiver messageReceiver;

    public MessageReceiveService(@Autowired(required = false) IMessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }


    public <T extends BaseMessage> ResponseBaseMessage receive(T message) {
        if (messageReceiver == null) return null;

        ResponseBaseMessage response = null;
        switch (message.getMsgType()) {
            case text -> response = messageReceiver.receiveText((TextMessage) message);
            case image -> response = messageReceiver.receivePic((PicMessage) message);
            case voice -> response = messageReceiver.receiveVoice((VoiceMessage) message);
            case video -> response = messageReceiver.receiveVideo((VideoMessage) message);
            case shortvideo -> response = messageReceiver.receiveShortVideo((ShortVideoMessage) message);
            case location -> response = messageReceiver.receiveLocationMessage((LocationMessage) message);
            case link -> response = messageReceiver.receiveLinkMessage((LinkMessage) message);
        }
        return response;
    }
}
