import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRequestGet {
    static String url = "https://speller.yandex.net/services/spellservice";

    public static void main(String[] args) {
        CloseableHttpResponse response = null;
        try{
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(url + "/checkTexts?text=Tuday+iss+fryday!+Su4+a+gud+day");

            response = client.execute(get);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                response.close();
            } catch(IOException ex){

            }
        }
    }
}
