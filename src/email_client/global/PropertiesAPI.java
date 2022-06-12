
package email_client.global;

public class PropertiesAPI {
        public static final String host = "mail.imaps.host";
        public static final String port = "mail.imaps.port";
        public static final String startTLS = "mail.imaps.starttls.enable";
        public static final String trustSSL = "mail.protocol.ssl.trust";
        public static final String mailProtocol = "mail.store.protocol"; //sử dụng đọc content mail

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
