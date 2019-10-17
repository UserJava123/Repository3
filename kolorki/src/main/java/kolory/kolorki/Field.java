package kolory.kolorki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Field {

	private Color color;
	private Rectangle rect;
	private int x;
	private int y;
	final static int FIELD_SIZE = 20;
	
	
	public Field(int x, int y)
	{
		this.x = x;
		this.y = y;
		rect = new Rectangle(x,y,FIELD_SIZE,FIELD_SIZE);
		Random generator = new Random();
		int red =  generator.nextInt(255);
		int green = generator.nextInt(255);
		int blue = generator.nextInt(255);
		color = (new Color(red,green,blue));
	}
	
	public void paint (Graphics g1)
	{
		Graphics2D g = (Graphics2D) g1;
		g.setColor(this.color);
		g.fill(this.rect);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getFieldSize() {
		return FIELD_SIZE;
	}
	
}
