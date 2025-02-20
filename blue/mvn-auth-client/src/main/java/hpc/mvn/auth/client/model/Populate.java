package hpc.mvn.auth.client.model;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Populate {
    private Member[] arr_member = new Member[4];

    //----------
    public Populate() {
        arr_member[0] = new Member("1807422020","okok","IRSYAD","Muhammad Nur Irsyad","muhammad.nurirsyad.tik18@mhsw.pnj.ac.id","TMJ - CCIT SEC 8");
        arr_member[1] = new Member("1807422021","okok","FRANKIE","Frankie Rasha","frankie.rasha.tik18@mhsw.pnj.ac.id","TMJ - REGULER 8");     
        arr_member[2] = new Member("1807422022","okok","BARYS","Barys Ventsislava","barys.ventsislava.tik18@mhsw.pnj.ac.id","TMD - REGULER 8");
        arr_member[3] = new Member("1807422023","okok","ONYEKACHI","Onyekachi Ghaliya","onyekachi.ghaliya.tik18@mhsw.pnj.ac.id","TI - AEU 8");        
    }
    
    //----------
    public Member[] getPopulateMember() {return this.arr_member;}
}
