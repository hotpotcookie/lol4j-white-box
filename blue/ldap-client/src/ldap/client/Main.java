package ldap.client;
//----------
import javax.naming.ldap.InitialLdapContext;
import ldap.client.connection.GetContext;
import ldap.client.view.Login;
import ldap.client.controller.LdapOperation;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("initialization ("+System.getProperty("os.name")+") in JDK "+System.getProperty("java.version")+" ...");
		LdapOperation ldapop = new LdapOperation(); 
		InitialLdapContext context = ldapop.verifiyContext();
		//----------
		if (context != null) {
			GetContext.closeContext(context); 
			Login home = new Login(); 
			home.setVisible(true);
		}
	}	
}
