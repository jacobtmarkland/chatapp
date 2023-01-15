package clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.channels.SocketChannel;

import javax.swing.JTextArea;

import clientgui.GUISetup;
import userlist.UserFrame;

public class ServerHandler extends AbstractServer{

	public ServerHandler(SocketChannel a, GUISetup guiSetup,UserFrame userFrame) {
		super(a, guiSetup, userFrame);
	}

	public void run() {
		try {
			BufferedReader reader = (BufferedReader)map.get("reader");
			GUISetup guiSetup = (GUISetup)map.get("guiSetup");
			UserFrame userFrame = (UserFrame)map.get("userFrame");
			JTextArea textArea = (JTextArea)guiSetup.map().get("textArea");
			
			String message;
			boolean first = true;
			try {
				while((message=reader.readLine())!=null) {
					if(first==false) {
						String a = textArea.getText();
						a+="\n";
						a+=message;
						textArea.setText(a);
					}else {
						message = reader.readLine();
						String id = "";
						for(int i = 0; i < message.length()-2;i++) {
							if(message.charAt(i)=='i' && message.charAt(i+1)=='d') {
								i=i+3;
								while(i<message.length()-1) {
									if(message.charAt(i)==' ') {
										break;
									}
									id+= message.charAt(i);
									i++;
								}
								break;
							}
						}
						Integer idva = Integer.valueOf(id);
						userFrame.id().setId(idva);
						first = false;
						reader.readLine();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}

}
