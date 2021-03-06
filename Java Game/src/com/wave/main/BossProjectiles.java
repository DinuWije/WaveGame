package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class BossProjectiles extends GameObject{
	
	private Handler handler; 
	private HUD hud;

	public BossProjectiles(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler, HUD hud) {
		super(x, y, id, WIDTH, HEIGHT);
		
		this.handler = handler;
		this.hud = hud;
		
		//random velocity to chase player upon spawn
		if (x < Game.player.getX()) velX = (ThreadLocalRandom.current().nextInt(1, 9));
		else velX = (ThreadLocalRandom.current().nextInt(-9, -1));
		
		velY = (ThreadLocalRandom.current().nextInt(0, 9));
		
	}

	public void tick() {
		if (this.rect.intersects(Game.player.rect)) {
			HUD.HEALTH -= (4* (hud.getLevel()/10));
			AudioPlayer.getSound("menu_sound").play();
		}
		x += velX;
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		if(y <= 0 || y >= Game.HEIGHT-45) killThis();
		if(x <= 0 || x >= Game.WIDTH-20) killThis();
		handler.addObject(new Trail(x, y, ID.Trail, 16, 16, Color.orange, 0.01f, handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public void killThis() {
		handler.removeObject(this);
	}
	
}
