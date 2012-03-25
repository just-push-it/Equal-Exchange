package net.worldoftomorrow.ee.Items;

public class DataID {
	public enum EDataID{
		STONE(0),
		SANDSTONE(1),
		WOOD(2),
		COBBLESTONE(3),
		BRICK(4),
		STONEBRICK(5),
		//Cloth Color
		WHITE(0),
		ORANGE(1),
		MAGENTA(2),
		LIGHTBLUE(3),
		YELLOW(4),
		LIGHTGREEN(5),
		PINK(6),
		GRAY(7),
		LIGHTGRAY(8),
		CYAN(9),
		PURPLE(10),
		BLUE(11),
		BROWN(12),
		GREEN(13),
		RED(14),
		BLACK(15);
		
		private final int id;
		private EDataID(int id){
			this.id = id;
		}
		
		public int getID(){
			return id;
		}

	}
	//Slabs
	public static final int STONE = 0;
	public static final int SANDSTONE = 1;
	public static final int WOOD = 2;
	public static final int COBBLESTONE = 3;
	public static final int BRICK = 4;
	public static final int STONEBRICK = 5;
	
	//Cloth Color
	public static final int WHITE = 0;
	public static final int ORANGE = 1;
	public static final int MAGENTA = 2;
	public static final int LIGHTBLUE = 3;
	public static final int YELLOW = 4;
	public static final int LIGHTGREEN = 5;
	public static final int PINK = 6;
	public static final int GRAY = 7;
	public static final int LIGHTGRAY = 8;
	public static final int CYAN = 9;
	public static final int PURPLE = 10;
	public static final int BLUE = 11;
	public static final int BROWN = 12;
	public static final int GREEN = 13;
	public static final int RED = 14;
	public static final int BLACK = 15;
}
