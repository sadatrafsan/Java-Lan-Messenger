package com.rebel.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transmitter extends Thread{
    
    String message,host;
    int port;
    
    public Transmitter(){
    
    }
    
    public Transmitter(String m,String h,int p){
    
        message = m;
        host = h;
        port = p;
    }
    
    @Override
    public void run(){
    
        try {
            Socket s = new Socket(host,port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
