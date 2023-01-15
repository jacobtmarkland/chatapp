package colorscheme;

import java.awt.Color;
import java.util.HashMap;

public class AbstractColorPalette implements ColorPalette{
	protected HashMap<String, Color> colorMap;
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
		colorMap = new HashMap<String,Color>();
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
		colorMap.put("red", red);
		colorMap.put("green", green);
		colorMap.put("blue", blue);
		colorMap.put("black", black);
		colorMap.put("cyan", cyan);
		colorMap.put("gray", gray);
		colorMap.put("lightgray", lightGray);
		colorMap.put("magenta", magenta);
		colorMap.put("orange", orange);
		colorMap.put("pink", pink);
		colorMap.put("white", white);
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
	public HashMap<String,Color> colorMap(){
		return this.colorMap;
	}

}
