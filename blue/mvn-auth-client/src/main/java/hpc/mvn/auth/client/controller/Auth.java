package hpc.mvn.auth.client.controller;
//----------
import hpc.mvn.auth.client.model.Member;
import hpc.mvn.auth.client.model.Populate;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
//----------
import javax.swing.*;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Auth {
    private final LogPanel objLog = new LogPanel();
    private final Util objUtil = new Util();
    private boolean passed = false;
    private int index;
    private Member[] arr_member = new Member[4];

    //----------
    public Auth() {this.arr_member = new Populate().getPopulateMember();}     

    //----------
    public void performLogin(JTextField inUsername, JPasswordField inPassword, JList listLogging, JScrollPane listScrollPane, JLabel valDisplayName, JLabel valUID, JLabel valMail, JLabel valGecos, JLabel valInitials, int filtered) throws UnsupportedEncodingException {              
        String getPass = String.valueOf(inPassword.getPassword());
        //----------
        if ((!inUsername.getText().equalsIgnoreCase("username or uid")) && (!getPass.equalsIgnoreCase("password"))) {
            for (int x = 0; x < arr_member.length; x++) {
                if (inUsername.getText().equals(arr_member[x].getUid()) && getPass.equals(arr_member[x].getPassword())) {
                    passed = true;
                    index = x;
                    break;
                } else {passed = false;}
            }

            //----------
            if (passed) {
                valDisplayName.setText(arr_member[index].getDisplayName()); valDisplayName.setForeground(new java.awt.Color(103,171,159));
                valUID.setText(arr_member[index].getUid()); valUID.setForeground(new java.awt.Color(103,171,159));
                valMail.setText(arr_member[index].getMail()); valMail.setForeground(new java.awt.Color(103,171,159));
                valGecos.setText(arr_member[index].getGecos()); valGecos.setForeground(new java.awt.Color(103,171,159));
                valInitials.setText((arr_member[index].getInitials()).toUpperCase()); valInitials.setForeground(new java.awt.Color(103,171,159));
                //----------
                if (filtered > 0) {
                    this.objLog.appendLog(URLEncoder.encode(inUsername.getText(), Charset.defaultCharset().toString())+" have logged in!", listLogging, listScrollPane);				
                } else {this.objLog.appendLog(inUsername.getText()+" have logged in!", listLogging, listScrollPane);}
            } else {
                valDisplayName.setText("displayName"); valDisplayName.setForeground(new java.awt.Color(153,153,153));
                valUID.setText("uid"); valUID.setForeground(new java.awt.Color(153,153,153));
                valMail.setText("mail"); valMail.setForeground(new java.awt.Color(153,153,153));
                valGecos.setText("gecos"); valGecos.setForeground(new java.awt.Color(153,153,153));
                valInitials.setText("initials"); valInitials.setForeground(new java.awt.Color(153,153,153));
                //----------
                if (filtered > 0) {                
                    this.objLog.appendLog(URLEncoder.encode(inUsername.getText(), Charset.defaultCharset().toString())+" have failed to log in!", listLogging, listScrollPane);
                } else {this.objLog.appendLog(inUsername.getText()+" have failed to log in!", listLogging, listScrollPane);}
            }
        }
    }

//----------
    public void performLogout(JTextField inUsername, JPasswordField inPassword, JList listLogging, JScrollPane listScrollPane, JLabel valDisplayName, JLabel valUID, JLabel valMail, JLabel valGecos, JLabel valInitials) throws UnsupportedEncodingException {		
        if (!valUID.getText().equals("uid")) {
            this.objUtil.placeHolderUsername(inUsername, 3);
            this.objUtil.placeHolderPassword(inPassword, 3);
            this.objLog.appendLog(valUID.getText()+" have logged out!", listLogging, listScrollPane);		
            //----------
            valDisplayName.setText("displayName"); valDisplayName.setForeground(new java.awt.Color(153,153,153));
            valUID.setText("uid"); valUID.setForeground(new java.awt.Color(153,153,153));
            valMail.setText("mail"); valMail.setForeground(new java.awt.Color(153,153,153));
            valGecos.setText("gecos"); valGecos.setForeground(new java.awt.Color(153,153,153));
            valInitials.setText("initials"); valInitials.setForeground(new java.awt.Color(153,153,153));
        }
    }
}
