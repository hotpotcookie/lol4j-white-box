package hpc.mvn.auth.client.controller;
//----------
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.UnsupportedEncodingException;
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
public class LogPanel {
	private static final Logger logger = LogManager.getLogger(LogPanel.class);

	//----------
	public void appendLog(String msg, JList listLogging, JScrollPane listScrollPane) throws UnsupportedEncodingException {
		DefaultListModel lst = new DefaultListModel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yy");
		DateTimeFormatter dtf_ext = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		DateTimeFormatter dtf_par = DateTimeFormatter.ofPattern("MM-yyyy");		
		LocalDateTime now = LocalDateTime.now();
		//----------		
		String line, error = "", info = "", last = "";
		String path = "src\\log\\"+dtf_par.format(now)+"\\app.log."+dtf_ext.format(now);
		String os = System.getProperty("os.name");
		if (!os.contains("Windows")) {path = "src/log/"+dtf_par.format(now)+"/app.log."+dtf_ext.format(now);}
		//----------					
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				error = line;
			}
		} catch (IOException ex) {System.out.println(">> LogPanel/loadLog: "+ex); logger.error(ex);}		
		//----------		
		for (int x = 0; x < listLogging.getModel().getSize(); x++) {
			lst.addElement(listLogging.getModel().getElementAt(x));			
		}
		//----------				
		if (error.contains("ERROR") && !error.contains("failed") && !error.contains("not registered")) {lst.addElement(error);}
		//----------				
		if (msg.contains("failed") || msg.contains("not registered")) {logger.error(msg);} else {logger.info(msg);}
		//----------					
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				if (line.contains("Reference Class")) {info = line;}
				last = line;
			}
		} catch (IOException ex) {System.out.println(">> LogPanel/loadLog: "+ex); logger.error(ex);}		
		//----------				
		System.out.println(last);
		if (!last.contains("(")) {lst.addElement(info);}		
		//----------
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				msg = line;
			}			
		} catch (IOException ex) {System.out.println(">> LogPanel/loadLog: "+ex); logger.error(ex);}
		//----------
		lst.addElement(URLDecoder.decode(msg,Charset.defaultCharset().toString()));				
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
			if (!os.contains("Windows")) {path = "src/log/"+dtf_par.format(now)+"/app.log."+dtf_ext.format(now);}
			//----------			
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
//				if (line.length() >= 76) {
//					line = line.substring(0, Math.min(line.length(), 76));
//					line += " ...";
//				}
				//----------		
				lst.addElement(URLDecoder.decode(line,Charset.defaultCharset().toString()));				
				listLogging.setModel(lst);
				listLogging.ensureIndexIsVisible(listLogging.getModel().getSize()-1);
				listLogging.setSelectedIndex(listLogging.getModel().getSize()-1);
			}
			//----------
			System.out.println("populating logs from src/log/"+dtf_par.format(now)+"/app.log."+dtf_ext.format(now)+" ...");
		} catch (IOException ex) {System.out.println(">> LogPanel/loadLog: "+ex); logger.error(ex);}
	}
}
