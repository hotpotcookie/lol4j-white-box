package hpc.mvn.auth.client;
//----------
import hpc.mvn.auth.client.view.Login;
//----------
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    //----------
    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.out.println("initialization ("+System.getProperty("os.name")+") in JDK "+System.getProperty("java.version")+" ...");	
        System.out.println("launching auth-client ...");			
        logger.debug("launching auth-client ...");      

        //----------		
        Login home = new Login(); 
        home.setVisible(true);
    }
}