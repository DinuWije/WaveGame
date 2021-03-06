package com.wave.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.wave.main.Game.STATE;

public class HUD {
	
	Game game; 
	
	HUD(Game game){
		this.game = game;
	}
	
	public static int HEALTH = 100;
	
	private int score = 0;
	private int tempScore;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		score++;
	}
	
	public void render(Graphics g) {
		//drawing text and any static boxes on the screen
		g.setColor(Color.white);
		
		g.fillRect(14, 14, 202, 34);
		g.fillRect(549, 14, 52, 34);
		g.fillRect(484, 14, 52, 34);
		
		g.drawString("Level: " + level, 15, 65);
		g.drawString("Score: " + score, 15, 80);
		g.drawString("High Score: " + game.getHighScore(), 15, 95);
		
		
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.fillRect(550, 15, 50, 32);
		g.fillRect(485, 15, 50, 32);
		
		g.setColor(Color.red);
		Font fnt = new Font("arial", 1, 17);
		g.setFont(fnt);
		g.drawString("Quit", 558, 37);
		g.drawString("Pause", 486, 37);
		
		//changes color of health bar based on health level
		if (HEALTH >= 50) {
			g.setColor(Color.green);
			g.fillRect(15, 15, HEALTH * 2, 32);
		}
		else if (HEALTH >= 20 && HEALTH < 50) {
			g.setColor(Color.orange);
			g.fillRect(15, 15, HEALTH * 2, 32);
		}
		else if(HEALTH < 20 && HEALTH > 0) {
			g.setColor(Color.red);
			g.fillRect(15, 15, HEALTH * 2, 32);
		} else {
			game.menu.killAll();
			Game.gameState = Game.STATE.GameOver;
		}
		
		
	}
	
	//bunch of getters and setters
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int Level) {
		this.level = Level;
	}
	
	public void setTempScore(int tempScore){
		this.tempScore = tempScore;
	}
	
	public int getTempScore() {
		return tempScore;
	}
	
}
