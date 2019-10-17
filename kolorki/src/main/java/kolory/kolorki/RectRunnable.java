package kolory.kolorki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class RectRunnable implements Runnable {

	private Field f;
	private Field f1; Field f2; Field f3; Field f4;
	private Graphics g;
	private double probability;
	
	public RectRunnable(Field f, Field f1, Field f2, Field f3, Field f4, Graphics g, double probability) {
		super();
		this.f = f;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.setG(g);
		this.probability = probability;
	}
	
	public synchronized  void chooseColor()
	{
		int red = (f1.getColor().getRed() + f2.getColor().getRed() + f3.getColor().getRed() + f4.getColor().getRed())/4;
		int green = (f1.getColor().getGreen() + f2.getColor().getGreen() + f3.getColor().getGreen() + f4.getColor().getGreen())/4;
		int blue = (f1.getColor().getBlue() + f2.getColor().getBlue() + f3.getColor().getBlue() + f4.getColor().getBlue())/4;
		f.setColor(new Color(red,green,blue));
	}
	
	public void run() 
	{
		while(true) {
		Random generator = new Random();
		double d = generator.nextDouble();
		if(d < probability) {
			int red = generator.nextInt(255);
			int green = generator.nextInt(255);
			int blue = generator.nextInt(255);
			f.setColor(new Color(red,green,blue));
			f.paint(getG());
		}
		else {
			chooseColor();
			f.paint(getG());
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public Field getF() {
		return f;
	}

	public void setF(Field f) {
		this.f = f;
	}

	public Field getF1() {
		return f1;
	}

	public void setF1(Field f1) {
		this.f1 = f1;
	}

	public Field getF2() {
		return f2;
	}

	public void setF2(Field f2) {
		this.f2 = f2;
	}

	public Field getF3() {
		return f3;
	}

	public void setF3(Field f3) {
		this.f3 = f3;
	}

	public Field getF4() {
		return f4;
	}

	public void setF4(Field f4) {
		this.f4 = f4;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	
}
