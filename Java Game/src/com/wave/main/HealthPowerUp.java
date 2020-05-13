package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;

public class HealthPowerUp extends GameObject{
	
	Handler handler;
	int healthAmt;

	public HealthPowerUp(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler, int healthAmt) {
		super(x, y, id, WIDTH, HEIGHT);
		this.rect.x = x;
		this.rect.y = y;
		this.handler = handler;
		this.healthAmt = healthAmt;
	}

	public void tick() {
		if (this.rect.intersects(Game.player.rect)) {
			HUD.HEALTH += healthAmt;
			handler.removeObject(this);
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

}
