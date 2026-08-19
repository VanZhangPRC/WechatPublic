package van.project.wechat.wechatPublic.services.messages.resp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseArticlesMessage extends ResponseBaseMessage {
    public ResponseArticlesMessage() {
        super();
        msgType = MsgType.news;
    }

    @JacksonXmlProperty(localName = "ArticleCount")
    private Long articleCount;

    @JacksonXmlProperty(localName = "Articles")
    private List<Article> articles;

    public ResponseArticlesMessage setArticles(List<Article> articles) {
        this.articles = articles;
        this.articleCount = (long) articles.size();
        return this;
    }

    @Data
    public static class Article {
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Title")
        private String title;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Description")
        private String description;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "PicUrl")
        private String picUrl;
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Url")
        private String url;
    }

}
        