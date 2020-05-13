package com.wave.main;
import java.awt.Color;
import java.awt.Graphics;

public class NukePowerUp extends GameObject{
	
	Handler handler;

	public NukePowerUp(int x, int y, ID id, int WIDTH, int HEIGHT, Handler handler) {
		super(x, y, id, WIDTH, HEIGHT);
		this.rect.x = x;
		this.rect.y = y;
		this.handler = handler;
	}

	public void tick() {
		if (this.rect.intersects(Game.player.rect)) {
			killAllEnemies();
			handler.removeObject(this);
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void killAllEnemies() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < handler.object.size(); j++) {
				GameObject tempObject2 = handler.object.get(j);
				if (!(tempObject2 instanceof Player)) {
					handler.removeObject(tempObject2);
				}
			}
		}
	}

}
