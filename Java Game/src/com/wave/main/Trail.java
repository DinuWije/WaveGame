package com.wave.main;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Trail extends GameObject{
	
	private float alpha = 1;
	private Handler handler;
	private Color color;
	private float life;

	public Trail(int x, int y, ID id, int WIDTH, int HEIGHT, Color color, float life, Handler handler) {
		super(x, y, id, WIDTH, HEIGHT);
		this.color = color;
		this.life = life;
		this.handler = handler;
	}

	public void tick() {
		if(alpha > life) {
			alpha -= 0.02f;	
		}
		else if (alpha <= 0) {
			handler.removeObject(this);
		}
		else {
			handler.removeObject(this);
		}
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));		
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
		g2d.setComposite(makeTransparent(1));
	}

}
