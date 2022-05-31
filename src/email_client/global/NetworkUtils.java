/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.global;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author notmiyouji
 */
public class NetworkUtils {
    
    
    public int CheckConnection(){
        try {
                URL url = new URL("http://www.google.com");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                if (con.getResponseCode() == 200){
                    return 1;
                }
            } catch (Exception exception) {     
            }
        return 0;
    }
    
}
