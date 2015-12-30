package org.staticvoid.gm.model.time;


/**
 * Class holding the representation of a game's progression.
 * 
 * Each year is 12 months.
 * Each month is 31 days.
 * Each day is... one day.
 * @author Grevor
 *
 */
public class DayProgression {
	private long day;
	public void fastForward(int days) { day += days; }
	
	public long getYear() { return 1 + (day / 372); }
	public int getMonth() { return (int) (1 + ((day / 31) % 12)); }
	public int getDay() { return (int) (1 + (day % 31)); }
	
	public long getTotalDays() { return day; }
	
	public Season getSeason() { return Season.values()[(getMonth() - 1 )]; }
}
