package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MenuBot extends GameObject{
	
	private Handler handler; 
	private Random r = new Random();
	private int randInt1 = r.nextInt(255);
	private int randInt2 = r.nextInt(255);
	private int randInt3 = r.nextInt(255);
	private Color mobColor = new Color(randInt1, randInt2, randInt3);

	public MenuBot(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler) {
		super(x, y, id, WIDTH, HEIGHT);
		this.handler = handler;
		
		int randX = r.nextInt(2);
		int randY = r.nextInt(2);
		//spawns bots with random starting velocities EXCLUDING Vel = 0
		if (randX == 1) velX = ThreadLocalRandom.current().nextInt(1, 10);
		else velX = ThreadLocalRandom.current().nextInt(-10, -1);
		
		if (randY == 1) velY = ThreadLocalRandom.current().nextInt(1, 10);
		else velY = ThreadLocalRandom.current().nextInt(-10, -1);
		
	}
	

	public void tick() {
		x += velX;
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		
		if(y <= 0 || y >= Game.HEIGHT-45) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, WIDTH, HEIGHT, mobColor, 0.01f, handler));
		
	}

	public void render(Graphics g) {
		
		g.setColor(mobColor);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
}
