package com.kuliah.jaringan;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class DisplayNet {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> ifs = NetworkInterface.getNetworkInterfaces();

        while (ifs.hasMoreElements()) {
            NetworkInterface nif = ifs.nextElement();
            System.out.println("Name : " + nif.getName());
            System.out.println("Display Name : " + nif.getDisplayName());

            Enumeration<InetAddress> inetAddresses = nif.getInetAddresses();

            while (inetAddresses.hasMoreElements()){
                InetAddress currInetAddr = inetAddresses.nextElement();
                System.out.println(nif.getDisplayName() + " address : " + currInetAddr.getHostName());
                System.out.println(nif.getDisplayName() + " host address : " + currInetAddr.getHostAddress());
            }
            System.out.println();
        }
    }
}
