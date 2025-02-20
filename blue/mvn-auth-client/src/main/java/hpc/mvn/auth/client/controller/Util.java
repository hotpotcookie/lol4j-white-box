package hpc.mvn.auth.client.controller;
//----------
import hpc.mvn.auth.client.model.Member;
import hpc.mvn.auth.client.model.Populate;
//----------
import java.awt.Desktop;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import javax.swing.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Util {
    private String mail;	
    private boolean passed;        
    private int index;
    private Member[] arr_member = new Member[4];                
    private final LogPanel objLog = new LogPanel();
        
    //----------	
    public Util() {this.arr_member = new Populate().getPopulateMember();}
        
    //----------
    public String randomGen(int len) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789";
        StringBuilder sb = new StringBuilder(len);
        //----------		
        for (int i = 0; i < len; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
       //----------		
       return sb.toString();		
    }

    //----------	
    public void requestPassword(JTextField inUsername, JList listLogging, JScrollPane listScrollPane, JLabel valInitials, int filtered) throws UnsupportedEncodingException {
        if (valInitials.getText().equals("initials") && !inUsername.getText().equals("")) { // cek kalau user field kosong dulu, baru cek found
            for (int x = 0; x < arr_member.length; x++) {
                if (inUsername.getText().equals(arr_member[x].getUid())) {
                    passed = true;
                    index = x;
                    break;
                } else {passed = false;}
            }			

            //----------
            if (passed) {
                JFrame jf = new JFrame(); jf.setAlwaysOnTop(true);
                String authuser = (String) JOptionPane.showInputDialog(jf,"Institutional Email","Request Password Reset",JOptionPane.INFORMATION_MESSAGE,null,null,"");
                authuser = authuser.trim().toLowerCase();
                //----------				
                if (authuser.equals(arr_member[index].getMail())) {
                    String ticket = this.randomGen(8);
                    String subject = "Reset%20Password%20Request%20%7C%20PNJ%20OpenLDAP%20Client%20%7C%20"+inUsername.getText()+"%20%7C%20%23"+ticket;
                    String body = "ticket:%20%23"+ticket+"%0Auid:%20"+inUsername.getText()+"%0A--%0APlease%20describe%20your%20issues%20here%20...";
                    String to = "hotpotcookie@gmail.com";
                    String urlString = "https://mail.google.com/mail/?view=cm&fs=1&to="+to+"&authuser="+authuser+"&su="+subject+"&body="+body;
                    //----------
                    try {
                        Desktop.getDesktop().browse(new URL(urlString).toURI());
                        this.objLog.appendLog(inUsername.getText()+" send new password request", listLogging, listScrollPane);				
                    } catch (Exception e) {System.out.println(e);}	
                } else {
                    JOptionPane.showMessageDialog(jf, "Please use your institutional email that are\nregistered to the username or uid only", "Request Password Fail", 0 ,null);
                    this.objLog.appendLog("account in email "+authuser+" are not registered", listLogging, listScrollPane);                    
                }
            } else {
                if (filtered > 0) {                
                    this.objLog.appendLog(URLEncoder.encode(inUsername.getText(), Charset.defaultCharset().toString())+" failed to send password request", listLogging, listScrollPane);
                } else {this.objLog.appendLog(inUsername.getText()+" failed to send password request", listLogging, listScrollPane);}
            }			
        }
    }		

    //----------	
    public void placeHolderUsername(JTextField inUsername, int bol) {
        switch (bol) {
            case 1:
                if (inUsername.getText().equals("username or uid")) {
                        inUsername.setForeground(new java.awt.Color(103,171,159));
                        inUsername.setText("");
                }	break;
            case 0:
                if (inUsername.getText().isEmpty()) {
                        inUsername.setForeground(new java.awt.Color(153,153,153));
                        inUsername.setText("username or uid");
                }	break;
            default:
                inUsername.setForeground(new java.awt.Color(153,153,153));
                inUsername.setText("username or uid");
                break;			
        }
    }
	
    //----------	
    public void placeHolderPassword(JPasswordField inPassword, int bol) {
        String getPass = String.valueOf(inPassword.getPassword());		
        //----------
        switch(bol) {
            case 1:
                if (getPass.equals("password")) {
                        inPassword.setForeground(new java.awt.Color(103,171,159));
                        inPassword.setText("");
                }				
                break;
            case 0:
                if (getPass.toLowerCase().trim().equals("")) {
                        inPassword.setForeground(new java.awt.Color(153,153,153));
                        inPassword.setText("password");
                }				
                break;
            default:
                inPassword.setForeground(new java.awt.Color(153,153,153));
                inPassword.setText("password");				
                break;
        }
    }
}