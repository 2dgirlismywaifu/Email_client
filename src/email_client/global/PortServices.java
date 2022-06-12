/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.global;

/**
 *
 * @author notmiyouji
 */
public class PortServices { 
    //Hầu hết các server đều chung các port
    String portIMAP = "993";
    String portTLS = "465";
    String portSSL = "587";

    public String getPortIMAP() {
        return portIMAP;
    }

    public String getPortTLS() {
        return portTLS;
    }

    public String getPortSSL() {
        return portSSL;
    }
    
}
