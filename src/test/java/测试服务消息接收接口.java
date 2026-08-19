import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import van.project.wechat.wechatPublic.common.properties.WechatProperties;
import van.project.wechat.wechatPublic.services.messages.IMessageReceiver;
import van.project.wechat.wechatPublic.services.messages.receive.*;
import van.project.wechat.wechatPublic.services.messages.resp.ResponseBaseMessage;
import van.project.wechat.wechatPublic.services.messages.resp.ResponseTextMessage;

import java.io.IOException;
import java.util.concurrent.*;


@SpringBootTest(classes = {测试服务消息接收接口.Config.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class 测试服务消息接收接口 {

    @EnableConfigurationProperties(value = {WechatProperties.class})
    @EnableAutoConfiguration
    @SpringBootConfiguration
    @ComponentScan(basePackages = {"van.project.wechat.wechatPublic.common.properties","van.project.wechat.wechatPublic.controller"})
    static class Config {
        @Bean
        public IMessageReceiver messageReceiver() {
            return new IMessageReceiver() {
                Logger logger = LoggerFactory.getLogger(TestApplication.class);
                ConcurrentHashMap<Long, CompletableFuture<String>> taskMap = new ConcurrentHashMap<>();
                ConcurrentHashMap<Long, Long> completedMap = new ConcurrentHashMap<>();

                @Override
                public ResponseBaseMessage receiveLinkMessage(LinkMessage message) {
                    return null;
                }

                @Override
                public ResponseBaseMessage receiveLocationMessage(LocationMessage message) {
                    return null;
                }

                @Override
                public ResponseBaseMessage receivePic(PicMessage message) {
                    return null;
                }

                @Override
                public ResponseBaseMessage receiveShortVideo(ShortVideoMessage message) {
                    return null;
                }

                @Override
                public ResponseBaseMessage receiveText(TextMessage message) {
                    if (message.getMsgId() == null)
                        return null;

                    if (completedMap.contains(message.getMsgId()))
                        return null;

                    CompletableFuture<String> newFuture = new CompletableFuture<>();
                    CompletableFuture<String> existingFuture = taskMap.putIfAbsent(message.getMsgId(), newFuture);
                    if (completedMap.containsKey(message.getMsgId())) {
                        if (existingFuture == null) {
                            taskMap.remove(message.getMsgId(), newFuture);
                        }
                        return null;
                    }

                    if (existingFuture != null) {
                        logger.info("接收到重复发送消息：{}", message.getContent());
                        try {
                            String result = existingFuture.get(6, TimeUnit.SECONDS);
                            return ResponseTextMessage.builder(message).content(result).build();
                        } catch (InterruptedException | ExecutionException e) {
                            logger.error("发生错误：", e);
                            return null;
                        } catch (TimeoutException e) {
                            return null;
                        }
                    } else {
                        try {
                            // handle business
                            String result = "处理完成";
                            Thread.sleep(12_000);
                            newFuture.complete(result);
                            completedMap.putIfAbsent(message.getMsgId(), System.currentTimeMillis());
                            taskMap.remove(message.getMsgId());
                            return ResponseTextMessage.builder(message).content(result).build();
                        } catch (InterruptedException e) {
                            logger.error("", e);
                            completedMap.remove(message.getMsgId());
                            taskMap.remove(message.getMsgId());
                            return null;
                        }
                    }
                }

                @Override
                public ResponseBaseMessage receiveVideo(VideoMessage message) {
                    return null;
                }

                @Override
                public ResponseBaseMessage receiveVoice(VoiceMessage message) {
                    return null;
                }
            };
        }

    }

    /**
     * 启动后微信后台调用接入接口
     * @throws IOException
     */
    @Test
    @DisplayName("接入接口测试")
    public void testEnter() throws IOException {
        System.in.read();
    }

    @Test
    @DisplayName("测试信息文本接收处理")
    public void testTextHandle() throws IOException {
        System.in.read();
    }


}
