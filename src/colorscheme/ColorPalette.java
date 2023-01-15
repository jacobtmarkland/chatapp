package colorscheme;

import java.awt.Color;
import java.util.HashMap;

public interface ColorPalette {
	HashMap<String,Color> colorMap();
	Color red();
	Color green();
	Color blue();
	Color black();
	Color cyan();
	Color gray();
	Color lightGray();
	Color magenta();
	Color orange();
	Color pink();
	Color white();
}
