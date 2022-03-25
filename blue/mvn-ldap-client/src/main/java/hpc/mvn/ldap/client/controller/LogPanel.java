package hpc.mvn.ldap.client.controller;
//----------
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author	Muhammad Nur Irsyad
 * @id		1807422020
 * @class	CCIT SEC 8 (TMJ)
 */
public class LogPanel {
	private static final Logger logger = LogManager.getLogger(LogPanel.class);

	//----------
	public void appendLog(String msg, JList listLogging, JScrollPane listScrollPane) {
		logger.info(msg);		
		//----------		
		DefaultListModel lst = new DefaultListModel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yy");
		DateTimeFormatter dtf_ext = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		DateTimeFormatter dtf_par = DateTimeFormatter.ofPattern("MM-yyyy");		
		LocalDateTime now = LocalDateTime.now();
		//----------
		for (int x = 0; x < listLogging.getModel().getSize(); x++) {
			lst.addElement(listLogging.getModel().getElementAt(x));			
		}
		//----------
		String line;
		String path = "src\\log\\"+dtf_par.format(now)+"\\app.log."+dtf_ext.format(now);
		String os = System.getProperty("os.name");
		if (!os.contains("Windows")) {path = "src/log/"+dtf_par.format(now)+"/"+dtf_ext.format(now);}
		//----------			
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				msg = line;
			}			
		} catch (IOException ex) {System.out.println(">> LogPanel/loadLog: "+ex); logger.error(ex);}
		//----------
		if (msg.length() >= 59) {
			msg = msg.substring(0, Math.min(msg.length(), 59));
			msg += "...";
		}
		//----------		
		lst.addElement(msg);				
		listLogging.setModel(lst);
		listLogging.ensureIndexIsVisible(listLogging.getModel().getSize()-1);
		listLogging.setSelectedIndex(listLogging.getModel().getSize()-1);
	}
	
	//----------
	public void loadLog(JList listLogging, JScrollPane listScrollPane) {
		try {
			DefaultListModel lst = new DefaultListModel();
			DateTimeFormatter dtf_ext = DateTimeFormatter.ofPattern("dd_MM_yyyy");
			DateTimeFormatter dtf_par = DateTimeFormatter.ofPattern("MM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			//----------
			String line;
			String path = "src\\log\\"+dtf_par.format(now)+"\\app.log."+dtf_ext.format(now);
			String os = System.getProperty("os.name");
			if (!os.contains("Windows")) {path = "src/log/"+dtf_par.format(now)+"/"+dtf_ext.format(now);}
			//----------			
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				if (line.length() >= 59) {
					line = line.substring(0, Math.min(line.length(), 59));
					line += "...";
				}
				//----------		
				lst.addElement(line);				
				listLogging.setModel(lst);
				listLogging.ensureIndexIsVisible(listLogging.getModel().getSize()-1);
				listLogging.setSelectedIndex(listLogging.getModel().getSize()-1);
			}
			//----------
			System.out.println("populating logs from src/log/"+dtf_par.format(now)+"/app.log."+dtf_ext.format(now)+" ...");
		} catch (IOException ex) {System.out.println(">> LogPanel/loadLog: "+ex); logger.error(ex);}
	}
}
