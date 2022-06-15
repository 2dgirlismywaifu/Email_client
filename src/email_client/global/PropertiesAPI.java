
package email_client.global;

public class PropertiesAPI {
        public final String host = "mail.imaps.host";
        public final String port = "mail.imaps.port";
        public final String startTLS = "mail.imaps.starttls.enable";
        public final String trustSSL = "mail.protocol.ssl.trust";
        public final String mailProtocol = "mail.store.protocol"; //sử dụng đọc content mail
        public final String debug = "mail.debug";

    public String getDebug() {
        return debug;
    }
        
    public String getMailProtocol() {
        return mailProtocol;
    }

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
