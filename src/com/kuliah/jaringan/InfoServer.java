package com.kuliah.jaringan;

import java.net.*;
import java.io.*;
import java.util.*;

public class InfoServer {
    private final int INFO_PORT=50000;
    private String datafromClient;

    public InfoServer(){
        BufferedReader inFromClient;
        DataOutputStream outToClient;
        Socket serverSocket;

        try{
            ServerSocket infoServer=new ServerSocket(INFO_PORT);
            while(true) {
                serverSocket=infoServer.accept();
                System.out.println("Ada Client"+" yang terkoneksi");
                inFromClient=new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                outToClient = new DataOutputStream(serverSocket.getOutputStream());
                outToClient.writeBytes("Info Server versi 0.1\n"+"hanya untuk testing ...\n"+
                        "Silahkan berikan TIME|NET|QUIT\n");

                boolean isQuit=false;
                while(!isQuit) {
                    datafromClient=inFromClient.readLine();
                    if(datafromClient.startsWith("TIME")) {
                        outToClient.writeBytes(new Date().toString()+"\n");
                    }
                    else if (datafromClient.startsWith("NET")) {
                        outToClient.writeBytes(InetAddress.getByName("localhost").toString()+"\n");
                    }
                    else if (datafromClient.startsWith("QUIT")) {
                        isQuit=true;
                    }
                }
                outToClient.close();
                inFromClient.close();
                serverSocket.close();
                System.out.println("Teknik Komputer 4 CB");
            }
        } catch(Exception e) {
            System.out.println("Error: "+e);
        }
    }
    public static void main (String[] args) {
        new InfoServer();
    }
}
