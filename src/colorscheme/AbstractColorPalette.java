package colorscheme;

import java.awt.Color;

public class AbstractColorPalette implements ColorPalette{
	protected Color red;
	protected Color green;
	protected Color blue;
	protected Color black;
	protected Color cyan;
	protected Color gray;
	protected Color lightGray;
	protected Color magenta;
	protected Color orange;
	protected Color pink;
	protected Color white;
	
	public AbstractColorPalette() {
		init();
	}
	public void init() {
		red = Color.red;
		green = Color.green;
		blue = Color.blue;
		black = Color.black;
		cyan = Color.cyan;
		gray = Color.gray;
		lightGray = Color.lightGray;
		magenta = Color.magenta;
		orange = Color.orange;
		pink = Color.pink;
		white = Color.white;
	}
	
	public Color red() {
		return red;
	}

	public Color green() {
		return green;
	}

	public Color blue() {
		return blue;
	}

	public Color black() {
		return black;
	}

	public Color cyan() {
		return cyan;
	}

	public Color gray() {
		return gray;
	}

	public Color lightGray() {
		return lightGray;
	}

	public Color magenta() {
		return magenta;
	}

	public Color orange() {
		return orange;
	}

	public Color pink() {
		return pink;
	}
	public Color white() {
		return white;
	}

}
