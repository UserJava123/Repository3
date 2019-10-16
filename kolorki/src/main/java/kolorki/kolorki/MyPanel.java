package kolorki.kolorki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel{

	
	private Field field[][];
	private List<RectRunnable> rrun = new ArrayList<RectRunnable>();
	private int probability;
	final static int FIELD_NUMBER = 20;
	
	public MyPanel(int probability)
	{
		setSize(FIELD_NUMBER * Field.FIELD_SIZE,FIELD_NUMBER * Field.FIELD_SIZE);
		field = new Field[FIELD_NUMBER][FIELD_NUMBER];
		int x = 0; 
		int y = 0;
		for(Field[] fi : field) {
			for(Field f : fi)
			{
				f = new Field(x*FIELD_NUMBER,y*FIELD_NUMBER);
				field[y][x] = f;
				x++;
			}
			y++;
			x=0;
		}
		this.probability = probability;
	}
	
	public synchronized void paintComponent(Graphics g1)
	{
		Graphics2D g = (Graphics2D) g1;
		for(Field[] fi : field) for(Field f : fi) 
		{
			g.setColor(f.getColor());
			g.fill(f.getRect());
		}
	}
	
	public void initialize()
	{
		int x = 0; 
		int y = 0;
		for(Field[] fi : field) {
			for(Field f : fi)
			{
		getRrun().add(new RectRunnable(f,field[((y-1)%Field.FIELD_SIZE+Field.FIELD_SIZE)%Field.FIELD_SIZE][x],
				field[(y+1)%Field.FIELD_SIZE][x],
				field[y][((x-1)%Field.FIELD_SIZE+Field.FIELD_SIZE)%Field.FIELD_SIZE],
				field[y][(x+1)%Field.FIELD_SIZE],this.getGraphics(),probability));
			x++;
			}
			y++;
			x=0;
		}
	}

	public List<RectRunnable> getRrun() {
		return rrun;
	}

	public void setRrun(List<RectRunnable> rrun) {
		this.rrun = rrun;
	}
}
