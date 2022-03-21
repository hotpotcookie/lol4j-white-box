package ldap.client.controller;
//----------
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class Logger {
	//----------
	public void appendLog(String msg, JList listLogging, JScrollPane listScrollPane) {
		DefaultListModel lst = new DefaultListModel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yy");
		LocalDateTime now = LocalDateTime.now();
		//----------
		for (int x = 0; x < listLogging.getModel().getSize(); x++) {
			lst.addElement(listLogging.getModel().getElementAt(x));			
		}
		//----------
		if (msg.length() >= 33) {
			msg = msg.substring(0, Math.min(msg.length(), 30));
			msg += "...";
		}
		//----------		
		lst.addElement("["+dtf.format(now)+"] "+msg);				
		listLogging.setModel(lst);
		listLogging.ensureIndexIsVisible(listLogging.getModel().getSize()-1);
		listLogging.setSelectedIndex(listLogging.getModel().getSize()-1);
	}
}
