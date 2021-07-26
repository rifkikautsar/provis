/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author rifki
 */
public class userSession {
    private static String username;    
    private static String nip;
    private static String nama;
    public static String getUsername(){
        return username;
    }
    
    public static void setUsername(String username){
        userSession.username = username;
    }
    
    public static String getNIP(){
        return nip;
    }
    
    public static void setNIP(String nip){
        userSession.nip = nip;
    }
    public static void setNama(String nm){
        userSession.nama = nm;
    }
    public static String getNama(){
        return nama;
    }
}
