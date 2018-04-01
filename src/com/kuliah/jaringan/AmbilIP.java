package com.kuliah.jaringan;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class AmbilIP {

    public static void main(String[] args) throws UnknownHostException{
        InetAddress inetAddr = InetAddress.getByName("localhost");
        System.out.println("host address : " + inetAddr.getHostAddress());
        System.out.println("host name : " + inetAddr.getHostName());
    }
}
