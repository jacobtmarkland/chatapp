package colorscheme;

import java.awt.Color;

public interface ClientColorScheme {
	Color messageBoxBackgroundColor();
	Color messageBoxForegroundColor();
	Color chatBoxBackgroundColor();
	Color chatBoxForegroundColor();
	Color buttonBackgroundColor();
	Color buttonForegroundColor();
	Color button2BackgroundColor();
	Color button2ForegroundColor();
	void setMessageBoxBackgroundColor(Color a);
	void setMessageBoxForegroundColor(Color a);
	void setChatBoxBackgroundColor(Color a);
	void setChatBoxForegroundColor(Color a);
	void setButtonBackgroundColor(Color a);
	void setButtonForegroundColor(Color a);
	void setButton2BackgroundColor(Color a);
	void setButton2ForegroundColor(Color a);
}
