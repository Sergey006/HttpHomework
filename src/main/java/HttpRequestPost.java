import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestPost {
    static String url = "https://speller.yandex.net/services/spellservice";

    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url + "/checkTexts?");
        httpPost.addHeader("Context-Type", "text/xml");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("text", "tuday"));
        params.add(new BasicNameValuePair("text", "Hillo"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
