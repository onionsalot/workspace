package helpers;
 
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
 
public abstract class BaseFeedParser {
    //XML TAGS
    static final String T_PUB_DATE = "pubDate";
    static final String T_DESCRIPTION = "description";
    static final String T_LINK = "link";
    static final String T_TITLE = "title";
    static final String T_ITEM = "item";
    static final String T_CHANNEL = "channel";
 
    List<Message> message;
    private URL feedUrl;
 
    protected BaseFeedParser(String feedUrl){
        try {
            this.feedUrl = new URL(feedUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
 
    protected InputStream getInputStream()
    {
        try
        {
            return this.feedUrl.openConnection().getInputStream();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
