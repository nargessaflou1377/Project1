
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sending {
    public StringBuilder send(String code)
    {
        StringBuilder response = null;
        HttpURLConnection connection = null;
        importCode a=new importCode();
        System.out.println("hi");
        String point=a.javaMaker(code);
        System.out.println(point);
            String urlParameters="";
            try {
                urlParameters = "tool=" + URLEncoder.encode("lagrange-interpolating-polynomial", "UTF-8") +
                        "&points=" + URLEncoder.encode(point, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
            }
            try {
                //Create connection
                URL url = new URL("https://www.dcode.fr/api/");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                
                connection.setRequestProperty("Content-Language", "en-US");
                
                connection.setUseCaches(false);
                connection.setDoOutput(true);
                
                //Send request
                DataOutputStream wr = new DataOutputStream (
                        connection.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.close();
                
                //Get Response
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                response = new StringBuilder();
                String line;
                
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                
            } catch (Exception e) {
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        return response;
    }
}
