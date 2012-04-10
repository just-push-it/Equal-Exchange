package net.worldoftomorrow.ee.logging;

import java.util.Date;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/*
 * Currently this class only formats HTML,
 * text is handled by a SimpleFormatter for now.
 */
public class LogFormatter extends Formatter{
	public String format(LogRecord rec){
		return FormatHTML(rec);
/*		String type = ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("LogType");
*		if(type.equalsIgnoreCase("html")){
*			return FormatHTML(rec);
*		}
*		else if(type.equalsIgnoreCase("text")){
*			return FormatText(rec);
*		} else { return FormatText(rec); }
*/
	}
	
	private String FormatHTML(LogRecord rec){
		StringBuffer buf = new StringBuffer(1500);
		
		buf.append("<tr>");
		
		/* Date */
		buf.append("<td>" + date(rec.getMillis()) + "</td>");
		
		/* Level */
		buf.append("<td>");
		if(rec.getLevel().intValue() >= Level.WARNING.intValue()){
			buf.append("<b>");
			buf.append(rec.getLevel());
			buf.append("</b>");
		} else {
			buf.append(rec.getLevel());
		}
		buf.append("</td>");
		
		/* Record */
		buf.append("<td>");
		//Make the text light red if the record is WARNING.
		if(rec.getLevel().intValue() == Level.WARNING.intValue()){
			buf.append("<p style=\"color:#CD5C5C\">");
		} //Red if the record is SEVERE.
		else if(rec.getLevel().intValue() == Level.SEVERE.intValue()){
			buf.append("<p style=\"color:#FF0000\">");
		} //Otherwise, black.
		else {
			buf.append("<p style=\"color:#000000\">");
		}
		
		buf.append(formatMessage(rec) + "</p>\n");
		buf.append("</td>");
		
		Throwable t = rec.getThrown();
		buf.append("<td>");
		if(t != null){
			String m = t.getMessage();
			String c = t.getClass().getName();
			buf.append(c);
			buf.append("</td><td>");
			buf.append(m);
		}
		buf.append("</td>");
		buf.append("</tr>\n");
		return buf.toString();
	}
	
	private String date(long milliseconds){
		SimpleDateFormat df = new SimpleDateFormat("MM.dd.yy HH:mm:ss z");
		Date d = new Date(milliseconds);
		return df.format(d);
	}
	
	public String getHead(Handler h){
		/*
		 * Check to see if the file exists to try and stop the logger from creating a new
		 * table on each reload
		 */
		File eelog = new File("EELog.html");
		long lm = eelog.lastModified();
		String head;
		if(eelog.exists()){
			head = null;
		} else {
		head = "<html>\n<head>\n" + (new Date()) + "\n</head>\n<body>\n<pre>\n"
		+ "<table border>\n  "
		+ "<tr><th>Time</th><th>Level</th><th>Record</th><th>Class</th><th>Message</th></tr>\n";
		}
		return head;
	}
	
	public String getTail(Handler h){
		File eelog = new File("EELog.html");
		String tail;
		if(eelog.exists()){
			tail = null;
		} else {
		tail = "</table>\n  </pre></body>\n</html>\n";
		}
		return tail;
		//return "</table>\n  </pre></body>\n</html>\n";
	}
}
