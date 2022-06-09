/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.global;

import java.util.regex.Pattern;

/**
 *
 * @author notmiyouji
 */
public class RegexEmail {
    public static boolean validation (String email) {
        String email_Pattern = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(email_Pattern);
        if (pattern.matcher(email).matches()) {
            return true;
        } else {
            return false;
        }
    }
    
}
