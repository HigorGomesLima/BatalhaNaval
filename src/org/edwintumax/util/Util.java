/**
 * @author Raydelto Hernández Perera
 */

package org.edwintumax.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Util {
	public static String getIp(){
		   String ip=null;
		    try {
		        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		        while (interfaces.hasMoreElements()) {
		            NetworkInterface iface = interfaces.nextElement();
		            // Filtrando localhost y tarjetas deshabilitadas
		            if (iface.isLoopback() || !iface.isUp())
		                continue;

		            Enumeration<InetAddress> addresses = iface.getInetAddresses();
		            while(addresses.hasMoreElements()) {
		                InetAddress addr = addresses.nextElement();
		                ip = addr.getHostAddress();
		                return ip;
		            }
		        }
		    } catch (SocketException e) {
		        throw new RuntimeException(e);
		    }
		    return ip;
	}

}
