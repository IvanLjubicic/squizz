package com.dia.squizz;

import android.app.Application;

public class Global extends Application{
	
	private int min, max, points, bonus, flag, pos;
	private String nickname;
	/*private int max;
	private int points;
	private int bonus;
	private int flag;*/
	
	public int getMin() {
        return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMin(int i) {
		min = i;
	}
	
	public void setMax(int i) {
		max = i;
	}
	
	public void setNick(String nick) {
		nickname = nick;
	}
	
	public String getNick() {
		return nickname;
	}
	
	public void setParams(int poi, int bon, int fla, int mi, int ma, int posit) {
		points = poi;
		bonus = bon;
		flag = fla;
		min = mi;
		max = ma;
		pos = posit;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public int getPoints() {
		return points;
	}
	public int getFlag() {
		return flag;
	}
	
	public int getPosit() {
		return pos;
	}
}
