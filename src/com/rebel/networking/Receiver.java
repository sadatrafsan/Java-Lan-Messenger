package com.rebel.networking;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

public class Receiver extends Thread{
    
    ServerSocket server;
    int port = 8877;
    GUI gui;
    
    public Receiver(GUI g,int p){
    
        port = p;
        gui = g;
        
        try{
            
            server = new ServerSocket(port);
        }
        catch(IOException ex){
            
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public Receiver(){
    
    }
    
    @Override
    public void run(){
    
        Socket clientSocket;
        
        try{
            
            while((clientSocket = server.accept()) != null){
                
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                
                if(line != null){
                    
                    gui.write(line);
                }
            }
        }
        catch(IOException ex){
            
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
