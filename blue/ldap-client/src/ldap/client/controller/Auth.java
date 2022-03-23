package ldap.client.controller;
//----------
import java.util.Properties;
import javax.naming.ldap.InitialLdapContext;
import javax.swing.*;
import ldap.client.connection.GetContext;
import ldap.client.connection.LoadProperties;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Auth {
	private final LogPanel objLog = new LogPanel();
	private final Util objUtil = new Util();
	public String displayName;
	public String uid;
	public String mail;
	public String gecos;
	public String initials;

	//----------
	public void performLogin(JTextField inUsername, JPasswordField inPassword, JList listLogging, JScrollPane listScrollPane, JLabel valDisplayName, JLabel valUID, JLabel valMail, JLabel valGecos, JLabel valInitials) {
		String getPass = String.valueOf(inPassword.getPassword());
		//----------
		if ((!inUsername.getText().equalsIgnoreCase("username or uid")) && (!getPass.equalsIgnoreCase("password"))) {
			Properties properties = LoadProperties.getConfig(false,"config.properties");
			String peopleDN = properties.getProperty("PEOPLE_DN");
			String getUsername = "uid="+inUsername.getText()+","+peopleDN;
			boolean passed = GetContext.getContext(getUsername,getPass); System.out.println(passed);
			//----------
			if (passed) {
				LdapOperation ldapop = new LdapOperation();
				InitialLdapContext context = ldapop.verifiyContext();
				ldapop.searchUid(context,inUsername.getText(),this);
				//----------
				valDisplayName.setText(displayName); valDisplayName.setForeground(new java.awt.Color(103,171,159));
				valUID.setText(uid); valUID.setForeground(new java.awt.Color(103,171,159));
				valMail.setText(mail); valMail.setForeground(new java.awt.Color(103,171,159));
				valGecos.setText(gecos); valGecos.setForeground(new java.awt.Color(103,171,159));
				valInitials.setText((initials).toUpperCase()); valInitials.setForeground(new java.awt.Color(103,171,159));
				//----------
				this.objLog.appendLog(inUsername.getText()+" logged in!", listLogging, listScrollPane);				
			} else {
				valDisplayName.setText("displayName"); valDisplayName.setForeground(new java.awt.Color(153,153,153));
				valUID.setText("uid"); valUID.setForeground(new java.awt.Color(153,153,153));
				valMail.setText("mail"); valMail.setForeground(new java.awt.Color(153,153,153));
				valGecos.setText("gecos"); valGecos.setForeground(new java.awt.Color(153,153,153));
				valInitials.setText("initials"); valInitials.setForeground(new java.awt.Color(153,153,153));
				//----------
				this.objLog.appendLog(inUsername.getText()+" failed to log in!", listLogging, listScrollPane);
			}
		}
	}
	
	//----------
	public void performLogout(JTextField inUsername, JPasswordField inPassword, JList listLogging, JScrollPane listScrollPane, JLabel valDisplayName, JLabel valUID, JLabel valMail, JLabel valGecos, JLabel valInitials) {		
		if (!valUID.getText().equals("uid")) {
			this.objUtil.placeHolderUsername(inUsername, 3);
			this.objUtil.placeHolderPassword(inPassword, 3);
			this.objLog.appendLog(valUID.getText()+" logged out!", listLogging, listScrollPane);		
			//----------
			valDisplayName.setText("displayName"); valDisplayName.setForeground(new java.awt.Color(153,153,153));
			valUID.setText("uid"); valUID.setForeground(new java.awt.Color(153,153,153));
			valMail.setText("mail"); valMail.setForeground(new java.awt.Color(153,153,153));
			valGecos.setText("gecos"); valGecos.setForeground(new java.awt.Color(153,153,153));
			valInitials.setText("initials"); valInitials.setForeground(new java.awt.Color(153,153,153));
		}
	}
}
