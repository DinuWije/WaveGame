package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;

public class FastEnemy extends GameObject{
	
	private Handler handler; 

	public FastEnemy(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler) {
		super(x, y, id, WIDTH, HEIGHT);
		
		this.handler = handler;
		velX = 10;
		velY = 10;
		
	}

	public void tick() {
		if (this.rect.intersects(Game.player.rect)) {
			HUD.HEALTH -= 2;
			velY *= -1;
			velX *= -1;
			AudioPlayer.getSound("menu_sound").play();
		}
		x += velX;
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		if(y <= 0 || y >= Game.HEIGHT-45) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		handler.addObject(new Trail(x, y, ID.Trail, 16, 16, Color.cyan, 0.5f, handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}

}
