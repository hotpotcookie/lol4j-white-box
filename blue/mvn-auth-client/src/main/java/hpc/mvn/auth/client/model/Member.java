package hpc.mvn.auth.client.model;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Member {
    private String uid, password, initials, displayName, mail, gecos;
    
    //----------   
    public Member(String uid, String password, String initials, String displayName, String mail, String gecos) {
        this.password = password;
        this.initials = initials;
        this.displayName = displayName;
        this.uid = uid;
        this.mail = mail;
        this.gecos = gecos;
    }

    //----------   
    public String getInitials() {return this.initials;}
    public String getPassword() {return this.password;}
    public String getDisplayName() {return this.displayName;}
    public String getUid() {return this.uid;}
    public String getMail() {return this.mail;}
    public String getGecos() {return this.gecos;}
}
