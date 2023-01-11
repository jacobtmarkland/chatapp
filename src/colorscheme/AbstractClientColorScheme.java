package colorscheme;

import java.awt.Color;

public abstract class AbstractClientColorScheme implements ClientColorScheme{
	protected Color chatBoxBackground;
	protected Color chatBoxForeground;
	protected Color messageBoxBackground;
	protected Color messageBoxForeground;
	protected Color buttonBackground;
	protected Color buttonForeground;
	protected Color button2Background;
	protected Color button2Foreground;
	
	public AbstractClientColorScheme() {
		chatBoxBackground = Color.WHITE;
		chatBoxForeground = Color.BLACK;
		messageBoxBackground = Color.WHITE;
		messageBoxForeground = Color.BLACK;
		buttonBackground = Color.WHITE;
		buttonForeground = Color.BLACK;
		button2Background = Color.WHITE;
		button2Foreground = Color.BLACK;
	}
	public AbstractClientColorScheme(Color cb, Color cf, Color mb, Color mf, Color bb, Color bf,Color b2b, Color b2f) {
		chatBoxBackground = cb;
		chatBoxForeground = cf;
		messageBoxBackground = mb;
		messageBoxForeground = mf;
		buttonBackground = bb;
		buttonForeground = bf;
		button2Background = b2b;
		button2Foreground = b2f;
	}
	
	public Color messageBoxBackgroundColor() {
		return messageBoxBackground;
	}

	public Color messageBoxForegroundColor() {
		return messageBoxForeground;
	}

	public Color chatBoxBackgroundColor() {
		return chatBoxBackground;
	}

	public Color chatBoxForegroundColor() {
		return chatBoxForeground;
	}

	public Color buttonBackgroundColor() {
		return buttonBackground;
	}

	public Color buttonForegroundColor() {
		return buttonForeground;
	}
	public Color button2BackgroundColor() {
		return button2Background;
	}

	public Color button2ForegroundColor() {
		return button2Foreground;
	}

	public void setMessageBoxBackgroundColor(Color a) {
		messageBoxBackground = a;
		
	}

	public void setMessageBoxForegroundColor(Color a) {
		messageBoxForeground = a;
		
	}

	public void setChatBoxBackgroundColor(Color a) {
		chatBoxBackground=a;
		
	}

	public void setChatBoxForegroundColor(Color a) {
		chatBoxForeground = a;
		
	}

	public void setButtonBackgroundColor(Color a) {
		buttonBackground =a;
		
	}

	public void setButtonForegroundColor(Color a) {
		buttonForeground = a;
		
	}

	public void setButton2BackgroundColor(Color a) {
		button2Background = a;
		
	}

	public void setButton2ForegroundColor(Color a) {
		button2Foreground = a;
	}
}
