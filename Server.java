/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

import java.io.*;
import java.net.*;
public class  Server
{
    public static void main(String args[])
    {
        ServerSocket srvrSkt = null;
        Socket sSocket = null;

        try
        {
            srvrSkt = new ServerSocket(8080);
            sSocket = srvrSkt.accept();
            InputStream is = sSocket.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);
            objClass sInput = (objClass)oi.readObject();
            FileOutputStream fileOut = new FileOutputStream("/obj/objClass.ser");
            System.out.println("The Following object has been Serialized: ");
            System.out.println(sInput.cStr);
            System.out.println("Thanks to me.");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sInput);
            out.close();
           
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Eroor during serialization... ");
            System.exit(1);
        }
    }
}
