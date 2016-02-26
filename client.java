/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

/**
 *
 * @author hrehman.bscs13seecs
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class Client 
{
    public static void main(String args[]) throws Exception 
    {
        try
        {
            Socket cSocket = new Socket("localhost", 8080);

            OutputStream os = cSocket.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a string to write on Server side: ");
            String s1 = in.nextLine();
            objClass cInput=new objClass(s1);
            obj.writeObject(cInput);
            obj.flush();
            obj.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization...");
            System.exit(1);
        }
     }
}
