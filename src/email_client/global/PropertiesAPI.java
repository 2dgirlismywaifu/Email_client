
package email_client.global;

public class PropertiesAPI {
        public String host = "mail.imaps.host";
        public String port = "mail.imaps.port";
        public String startTLS = "mail.imaps.starttls.enable";
        public String trustSSL = "mail.protocol.ssl.trust";

    public String getTrustSSL() {
        return trustSSL;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getStartTLS() {
        return startTLS;
    }
        
    
}
