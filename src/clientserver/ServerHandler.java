package clientserver;

import java.io.IOException;
import java.nio.channels.SocketChannel;

import clientgui.GUISetup;

public class ServerHandler extends AbstractServer{

	public ServerHandler(SocketChannel a, GUISetup guiSetup) {
		super(a, guiSetup);
	}

	public void run() {
		String message;
		boolean first = true;
		try {
			while((message=super.reader.readLine())!=null) {
				if(first==false) {
					System.out.println(message);
					String a = guiSetup.textArea().getText();
					a+="\n";
					a+=message;
					guiSetup.textArea().setText(a);
				}else {
					message = super.reader.readLine();
					message = super.reader.readLine();
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
					SingletonUserFrame.getInstance("r").userFrame.id().setId(idva);//should not matter as long as it does not start as null
					first = false;
					super.reader.readLine();
					super.reader.readLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
