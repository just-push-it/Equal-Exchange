package net.worldoftomorrow.ee.Items;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.worldoftomorrow.ee.StringHelper;

public enum DataItem {
	STONE_SLAB(DataID.STONE, "Stone", "stone", "rock"),
	SANDSTONE_SLAB(DataID.SANDSTONE, "Sandstone", "sandstone", "sstone"),
	WOOD_SLAB(DataID.WOOD, "Wood", "wood", "wd"),
	COBBLESTONE_SLAB(DataID.COBBLESTONE, "Cobblestone", "cobblestone", "cobble"),
	BRICK_SLAB(DataID.BRICK, "Brick", "brick", "redbrick"),
	STONEBRICK_SLAB(DataID.STONEBRICK, "Stonebrick", "stonebrick", "sbrick"),
	//Wool Colors
	WHITE(DataID.WHITE, "White", "white", "w"),
	ORANGE(DataID.ORANGE, "Orange", "orange", "o"),
	MAGENTA(DataID.MAGENTA, "Magenta", "magenta", "m"),
	LIGHTBLUE(DataID.LIGHTBLUE, "Lightblue", "lightblue", "lblu"),
	YELLOW(DataID.YELLOW, "Yellow", "yellow", "y", "gold"),
	LIGHTGREEN(DataID.LIGHTGREEN, "Lightgreen", "lightgreen", "lgree"),
	PINK(DataID.PINK, "Pink", "pink", "pi"),
	GRAY(DataID.GRAY, "Gray", "gray", "grey", "darkgrey", "darkgray", "dg", "gra"),
	LIGHTGRAY(DataID.LIGHTGRAY, "Lightgray", "lightgray", "lightgrey", "lgra", "lgre"),
	CYAN(DataID.CYAN, "Cyan", "cyan", "c"),
	PURPLE(DataID.PURPLE, "Purple", "purple", "pur"),
	BLUE(DataID.BLUE, "Blue", "blue", "darkblue", "dbl", "blu"),
	BROWN(DataID.BROWN, "Brown", "brown", "br"),
	GREEN(DataID.GREEN, "Green", "green", "darkgreen", "dg", "gre"),
	RED(DataID.RED, "Red", "red", "r"),
	BLACK(DataID.BLACK, "Black", "black", "bla");
	
	private final int id;
	private final String name;
	private final String lookupKeys[];
	
	private static final Map<Integer, DataItem> ids = new HashMap<Integer, DataItem>();
	
	private static final Map<String, DataItem> lookup = new LinkedHashMap<String, DataItem>();
	
	static {
    	for(DataItem item : EnumSet.allOf(DataItem.class)){
    		ids.put(item.id, item);
    		for(String key : item.lookupKeys){
    			lookup.put(key, item);
    		}
    	}
    }
	
	DataItem(int id, String name, String lookupKey){
    	this.id = id;
    	this.name = name;
    	this.lookupKeys = new String[] { lookupKey };
    }
    
	DataItem(int id, String name, String... lookupKeys){
    	this.id = id;
    	this.name = name;
    	this.lookupKeys = lookupKeys;
    }
    
    public static DataItem fromID(int id){
    	return ids.get(id);
    }
    
    public static String toName(int id){
    	DataItem item = ids.get(id);
    	if(item != null){ return item.getName(); }
    	else { return "#" + id; }
    }
    
    public static DataItem lookup(String name){
    	return lookup(name, true);
    }
    
    public static DataItem lookup(String name, boolean fuzzy){
    	try {
    		return fromID(Integer.parseInt(name));
    	} catch (NumberFormatException e){
    		return StringHelper.lookup(lookup, name, fuzzy);
    	}
    }
    
    public int getID(){
    	return id;
    }
    
    public String getName(){
    	return name;
    }
}
