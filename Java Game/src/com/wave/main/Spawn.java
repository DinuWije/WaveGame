package com.wave.main;
import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	private static int levelLength = 500;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		//scoreKeep and levelLength are used to increment the level
		scoreKeep++;
		if(scoreKeep >= levelLength) {
			scoreKeep = 0;
			hud.setLevel((hud.getLevel())+1);
			
			//spawning enemies & power-ups at different levels/at random
			if((hud.getLevel() % 4) == 0) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, 10, 10, handler));
			}
			else if (r.nextInt(2) == 1) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, 16, 16, handler));
			}
			
			if (hud.getLevel() % 6 == 0) {
				handler.addObject(new TrackerEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.TrackerEnemy, 20, 20, handler));
			}
			
			if ((hud.getLevel() % 5 == 0) && (r.nextInt(3) == 1)) {
				handler.addObject(new NukePowerUp(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.NukePowerUp, 10, 10, handler));
			}
			
			if(((hud.getLevel() % 2) == 0) && (r.nextInt(2) == 1)) {
				handler.addObject(new HealthPowerUp(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.HealthPowerUp, 10, 10, handler, 15));
			}
			
			if((hud.getLevel() % 10 == 0)) {
				killAllEnemies();
				handler.addObject(new BossEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(50), ID.TrackerEnemy, 75, 75, handler, hud));
			}
			
		}
	}
	
	public static int getLevelLength() {
		return levelLength;
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
