package com.notelysia.emailclient.global;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckAccount {
    
    GetSessionIMAPS getSession = new GetSessionIMAPS();
    
    public void checkLogin(String imap, String storeType, String user, String password) 
            throws NoSuchProviderException, MessagingException {
        Session emailSession = getSession.getSession(imap, storeType, user, password);
        Store store = emailSession.getStore(storeType);
        store.connect();
        // close the store      
        store.close();             
    }
    
}
