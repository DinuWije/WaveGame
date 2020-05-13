package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;

public class TrackerEnemy extends GameObject{
	
	private Handler handler; 

	public TrackerEnemy(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler) {
		super(x, y, id, WIDTH, HEIGHT);
		
		this.handler = handler;
		velX = 2;
		velY = 2;
		
	}

	public void tick() {
		if (this.rect.intersects(Game.player.rect)) {
			HUD.HEALTH -= 2;
			velY *= -1;
			velX *= -1;
			AudioPlayer.getSound("menu_sound").play();
		}
		
		//chases player
		if (x < Game.player.getX()) {
			x += velX;
		} else if (x > Game.player.getX()) {
			x -= velX;
		}
		
		if (y < Game.player.getY()) {
			y += velY;
		} else if (y > Game.player.getY()) {
			y -= velY;
		}
		
		this.rect.x = x;
		this.rect.y = y;
		if(y <= 0 || y >= Game.HEIGHT-45) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		handler.addObject(new Trail(x, y, ID.Trail, 16, 16, Color.magenta, 0.01f, handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}

}
