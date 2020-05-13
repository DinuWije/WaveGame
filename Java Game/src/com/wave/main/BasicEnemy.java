package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{
	
	private Handler handler; 
	
	

	public BasicEnemy(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler) {
		super(x, y, id, WIDTH, HEIGHT);
		
		this.handler = handler;
		velX = 5;
		velY = 5;
		
	}

	public void tick() {
		// when enemy interacts with the player
		if (this.rect.intersects(Game.player.rect)) {
			HUD.HEALTH -= 1;
			velY *= -1;
			velX *= -1;
			AudioPlayer.getSound("menu_sound").play();
		}
		//moving the enemy and it's rectangle hit box
		x += velX;
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		
		//what happens if the enemy hits the walls 
		if(y <= 0 || y >= Game.HEIGHT-45) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		
		//adding a trial to the enemy
		handler.addObject(new Trail(x, y, ID.Trail, 16, 16, Color.red, 0.01f, handler));
		
	}

	public void render(Graphics g) {
		//giving the looks of the enemy
		g.setColor(Color.red);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
}
