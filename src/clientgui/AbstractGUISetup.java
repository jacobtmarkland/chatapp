package clientgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientserver.NetworkSetup;
import colorscheme.ClientColorScheme;
import colorscheme.WhiteBlackClientColorScheme;
import shell.Shell;
import userlist.ClientUserInput;
import userlist.UserFrame;
import userlist.UserInput;

public abstract class AbstractGUISetup implements GUISetup{
	protected JFrame frame;
	protected ClientColorScheme colorScheme;
	protected JTextField textField;
	protected JTextArea textArea;
	protected JButton sendButton;
	protected JButton connectButton;
	protected UserInput userInput;
	
	
	public AbstractGUISetup(){
		this.userInput = new ClientUserInput();
	}
	public AbstractGUISetup(ClientColorScheme a){
		this.colorScheme = a;
		this.userInput = new ClientUserInput();
	}
	
	protected void sendMessage(UserFrame userFrame,NetworkSetup networkSetup, Shell shell) {
		if(hasSemiColon(textField.getText())){
			semiColonError();
			return;
		}else {
			userInput.readLine(textField.getText());
			if(userInput.isUserInput()) {
				networkSetup.sendMessage("/broadcast;-e;("+userFrame.id().name() + " " +userFrame.id().id() + ":"+textField.getText()+")");
				return;
			}else {
				shell.readLine(userInput.currLine());
				String exec = shell.executeCmd();
				String text = textArea.getText();
				text+="\n";
				text+=exec;
				textArea.setText(text);
				return;
			}
		}
	}
	
	protected void semiColonError() {
		JOptionPane.showMessageDialog(null, "Semi-colons are not allowed");
		textField.setText("");
	}
	protected boolean hasSemiColon(String snip) {
		for(int i = 0; i < snip.length(); i++) {
			if(snip.charAt(i)==';') {
				return true;
			}
		}
		return false;
	}
	
	public void paint(UserFrame userFrame, NetworkSetup networkSetup, Shell shell) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,450);
		String name = JOptionPane.showInputDialog("Enter your name: ");
		userFrame.id().setName(name);
		frame.setTitle("Client: "+ name +" - Chat Room");
		colorScheme = new WhiteBlackClientColorScheme();
		textField = new JTextField(10);
		textField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage(userFrame,networkSetup, shell);
				}
				if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
					semiColonError();
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		textArea = new JTextArea(10,10);
		connectButton = new JButton();
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setEditable(false);
		sendButton = new JButton();
		sendButton.addActionListener(e -> sendMessage(userFrame,networkSetup, shell));
		textField.setBackground(colorScheme.chatBoxBackgroundColor());
		textField.setForeground(colorScheme.chatBoxForegroundColor());
		textArea.setBackground(colorScheme.messageBoxBackgroundColor());
		textArea.setForeground(colorScheme.messageBoxForegroundColor());
		sendButton.setBackground(colorScheme.buttonBackgroundColor());
		sendButton.setForeground(colorScheme.buttonForegroundColor());
		connectButton.setBackground(colorScheme.button2BackgroundColor());
		connectButton.setForeground(colorScheme.button2ForegroundColor());
		sendButton.setPreferredSize(new Dimension(40,40));
		sendButton.setText("Send Message");
		connectButton.setText("Connect");
		connectButton.addActionListener(e -> networkSetup.go(userFrame, this));
		connectButton.setPreferredSize(new Dimension(10,40));
		frame.add(BorderLayout.CENTER, scroll);
		frame.add(BorderLayout.NORTH, textField);
		frame.add(BorderLayout.SOUTH, sendButton);
		frame.add(BorderLayout.EAST, connectButton);
		frame.setVisible(true);
	}
	
	public void go(UserFrame userFrame, NetworkSetup networkSetup, Shell shell) {
		paint(userFrame, networkSetup, shell);
	}
	public JFrame frame() {
		return frame;
	}

	public ClientColorScheme colorScheme() {
		return colorScheme;
	}
	public JTextField textField() {
		return textField;
	}

	public JTextArea textArea() {
		return textArea;
	}

	public JButton sendButton() {
		return sendButton;
	}

	public JButton connectButton() {
		return connectButton;
	}
	public UserInput userInput() {
		return this.userInput;
	}
}
