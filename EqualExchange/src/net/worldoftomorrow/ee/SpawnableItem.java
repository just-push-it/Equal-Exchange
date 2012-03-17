package net.worldoftomorrow.ee;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.command.CommandException;

public enum SpawnableItem {
    STONE(SpawnableID.STONE, "Stone", "stone", "rock"),
    GRASS(SpawnableID.GRASS, "Grass", "grass"),
    DIRT(SpawnableID.DIRT, "Dirt", "dirt"),
    COBBLESTONE(SpawnableID.COBBLESTONE, "Cobblestone", "cobblestone", "cobble"),
    WOOD(SpawnableID.WOOD, "Wood", "wood", "woodplank", "plank", "woodplanks", "planks"),
    SAPLING(SpawnableID.SAPLING, "Sapling", "sapling", "seedling"),
    SAND(SpawnableID.SAND, "Sand", "sand"),
    GRAVEL(SpawnableID.GRAVEL, "Gravel", "gravel"),
    GOLD_ORE(SpawnableID.GOLD_ORE, "Gold ore", "goldore"),
    IRON_ORE(SpawnableID.IRON_ORE, "Iron ore", "ironore"),
    COAL_ORE(SpawnableID.COAL_ORE, "Coal ore", "coalore"),
    LOG(SpawnableID.LOG, "Log", "log", "tree", "pine", "oak", "birch", "redwood"),
    LEAVES(SpawnableID.LEAVES, "Leaves", "leaves", "leaf"),
    SPONGE(SpawnableID.SPONGE, "Sponge", "sponge"),
    GLASS(SpawnableID.GLASS, "Glass", "glass"),
    LAPIS_LAZULI_ORE(SpawnableID.LAPIS_LAZULI_ORE, "Lapis lazuli ore", "lapislazuliore", "blueore", "lapisore"),
    LAPIS_LAZULI(SpawnableID.LAPIS_LAZULI_BLOCK, "Lapis lazuli", "lapislazuli", "lapislazuliblock", "bluerock"),
    DISPENSER(SpawnableID.DISPENSER, "Dispenser", "dispenser"),
    SANDSTONE(SpawnableID.SANDSTONE, "Sandstone", "sandstone"),
    NOTE_BLOCK(SpawnableID.NOTE_BLOCK, "Note block", "musicblock", "noteblock", "note", "music", "instrument"),
    POWERED_RAIL(SpawnableID.POWERED_RAIL, "Powered Rail", "poweredrail", "boosterrail", "poweredtrack", "boostertrack", "booster"),
    DETECTOR_RAIL(SpawnableID.DETECTOR_RAIL, "Detector Rail", "detectorrail", "detector"),
    WEB(SpawnableID.WEB, "Web", "web", "spiderweb"),
    LONG_GRASS(SpawnableID.LONG_GRASS, "Long grass", "longgrass", "tallgrass"),
    DEAD_BUSH(SpawnableID.DEAD_BUSH, "Shrub", "deadbush", "shrub", "deadshrub", "tumbleweed"),
    CLOTH(SpawnableID.CLOTH, "Wool", "cloth", "wool"),
    YELLOW_FLOWER(SpawnableID.YELLOW_FLOWER, "Yellow flower", "yellowflower", "flower"),
    RED_FLOWER(SpawnableID.RED_FLOWER, "Red rose", "redflower", "redrose", "rose"),
    BROWN_MUSHROOM(SpawnableID.BROWN_MUSHROOM, "Brown mushroom", "brownmushroom", "mushroom"),
    RED_MUSHROOM(SpawnableID.RED_MUSHROOM, "Red mushroom", "redmushroom"),
    GOLD_BLOCK(SpawnableID.GOLD_BLOCK, "Gold block", "gold", "goldblock"),
    IRON_BLOCK(SpawnableID.IRON_BLOCK, "Iron block", "iron", "ironblock"),
    STEP(SpawnableID.STEP, "Step", "slab", "stoneslab", "step", "halfstep"),
    BRICK(SpawnableID.BRICK, "Brick", "brick", "brickblock"),
    TNT(SpawnableID.TNT, "TNT", "tnt", "c4", "explosive"),
    BOOKCASE(SpawnableID.BOOKCASE, "Bookcase", "bookshelf", "bookshelves", "bookcase", "bookcases"),
    MOSSY_COBBLESTONE(SpawnableID.MOSSY_COBBLESTONE, "Cobblestone (mossy)", "mossycobblestone", "mossstone", "mossystone", "mosscobble", "mossycobble", "moss", "mossy", "sossymobblecone"),
    OBSIDIAN(SpawnableID.OBSIDIAN, "Obsidian", "obsidian"),
    TORCH(SpawnableID.TORCH, "Torch", "torch", "light", "candle"),
    WOODEN_STAIRS(SpawnableID.WOODEN_STAIRS, "Wooden stairs", "woodstair", "woodstairs", "woodenstair", "woodenstairs"),
    CHEST(SpawnableID.CHEST, "Chest", "chest", "storage", "storagechest"),
    DIAMOND_ORE(SpawnableID.DIAMOND_ORE, "Diamond ore", "diamondore"),
    DIAMOND_BLOCK(SpawnableID.DIAMOND_BLOCK, "Diamond block", "diamond", "diamondblock"),
    WORKBENCH(SpawnableID.WORKBENCH, "Workbench", "workbench", "table", "craftingtable", "crafting"),
    FURNACE(SpawnableID.FURNACE, "Furnace", "furnace"),
    LADDER(SpawnableID.LADDER, "Ladder", "ladder"),
    MINECART_TRACKS(SpawnableID.MINECART_TRACKS, "Minecart tracks", "track", "tracks", "minecrattrack", "minecarttracks", "rails", "rail"),
    COBBLESTONE_STAIRS(SpawnableID.COBBLESTONE_STAIRS, "Cobblestone stairs", "cobblestonestair", "cobblestonestairs", "cobblestair", "cobblestairs"),
    LEVER(SpawnableID.LEVER, "Lever", "lever", "switch", "stonelever", "stoneswitch"),
    STONE_PRESSURE_PLATE(SpawnableID.STONE_PRESSURE_PLATE, "Stone pressure plate", "stonepressureplate", "stoneplate"),
    WOODEN_PRESSURE_PLATE(SpawnableID.WOODEN_PRESSURE_PLATE, "Wooden pressure plate", "woodpressureplate", "woodplate", "woodenpressureplate", "woodenplate", "plate", "pressureplate"),
    REDSTONE_ORE(SpawnableID.REDSTONE_ORE, "Redstone ore", "redstoneore"),
    REDSTONE_TORCH_ON(SpawnableID.REDSTONE_TORCH_ON, "Redstone torch (on)", "redstonetorch", "redstonetorchon", "rstorchon", "redtorch"),
    STONE_BUTTON(SpawnableID.STONE_BUTTON, "Stone Button", "stonebutton", "button"),
    ICE(SpawnableID.ICE, "Ice", "ice"),
    SNOW_BLOCK(SpawnableID.SNOW_BLOCK, "Snow block", "snowblock"),
    CACTUS(SpawnableID.CACTUS, "Cactus", "cactus", "cacti"),
    CLAY(SpawnableID.CLAY, "Clay", "clay"),
    JUKEBOX(SpawnableID.JUKEBOX, "Jukebox", "jukebox", "stereo", "recordplayer"),
    FENCE(SpawnableID.FENCE, "Fence", "fence"),
    PUMPKIN(SpawnableID.PUMPKIN, "Pumpkin", "pumpkin"),
    NETHERRACK(SpawnableID.NETHERRACK, "Netherrack", "redmossycobblestone", "redcobblestone", "redmosstone", "redcobble", "netherstone", "netherrack", "nether", "hellstone"),
    SOUL_SAND(SpawnableID.SLOW_SAND, "Soul sand", "slowmud", "mud", "soulsand", "hellmud"),
    GLOWSTONE(SpawnableID.LIGHTSTONE, "Glowstone", "brittlegold", "glowstone", "lightstone", "brimstone", "australium"),
    JACK_O_LANTERN(SpawnableID.JACKOLANTERN, "Pumpkin (on)", "pumpkinlighted", "pumpkinon", "litpumpkin", "jackolantern"),
    TRAP_DOOR(SpawnableID.TRAP_DOOR, "Trap door", "trapdoor", "hatch", "floordoor"),
    STONE_BRICK(SpawnableID.STONE_BRICK, "Stone brick", "stonebrick", "sbrick", "smoothstonebrick"),
    RED_MUSHROOM_CAP(SpawnableID.RED_MUSHROOM_CAP, "Red mushroom cap", "giantmushroomred", "redgiantmushroom", "redmushroomcap"),
    BROWN_MUSHROOM_CAP(SpawnableID.BROWN_MUSHROOM_CAP, "Brown mushroom cap", "giantmushroombrown", "browngiantmushoom", "brownmushroomcap"),
    IRON_BARS(SpawnableID.IRON_BARS, "Iron bars", "ironbars", "ironfence"),
    GLASS_PANE(SpawnableID.GLASS_PANE, "Glass pane", "window", "glasspane", "glasswindow"),
    MELON_BLOCK(SpawnableID.MELON_BLOCK, "Melon (block)", "melonblock"),
    VINE(SpawnableID.VINE, "Vine", "vine", "vines", "creepers"),
    FENCE_GATE(SpawnableID.FENCE_GATE, "Fence gate", "fencegate", "gate"),
    BRICK_STAIRS(SpawnableID.BRICK_STAIRS, "Brick stairs", "brickstairs", "bricksteps"),
    STONE_BRICK_STAIRS(SpawnableID.STONE_BRICK_STAIRS, "Stone brick stairs", "stonebrickstairs", "smoothstonebrickstairs"),
    MYCELIUM(SpawnableID.MYCELIUM, "Mycelium", "fungus", "mycel"),
    LILY_PAD(SpawnableID.LILY_PAD, "Lily pad", "lilypad", "waterlily"),
    NETHER_BRICK(SpawnableID.NETHER_BRICK, "Nether brick", "netherbrick"),
    NETHER_BRICK_FENCE(SpawnableID.NETHER_BRICK_FENCE, "Nether brick fence", "netherbrickfence", "netherfence"),
    NETHER_BRICK_STAIRS(SpawnableID.NETHER_BRICK_STAIRS, "Nether brick stairs", "netherbrickstairs", "netherbricksteps", "netherstairs", "nethersteps"),
    ENCHANTMENT_TABLE(SpawnableID.ENCHANTMENT_TABLE, "Enchantment table", "enchantmenttable", "enchanttable"),
    BREWING_STAND(SpawnableID.BREWING_STAND, "Brewing Stand", "brewingstand"),
    CAULDRON(SpawnableID.CAULDRON, "Cauldron"),
    END_STONE(SpawnableID.END_STONE, "End Stone", "endstone", "enderstone", "endersand"),
    REDSTONE_LAMP_OFF(SpawnableID.REDSTONE_LAMP_OFF, "Redstone lamp (off)", "redstonelamp", "redstonelampoff", "rslamp", "rslampoff", "rsglow", "rsglowoff");
    
    private final int id;
    private final String name;
    private final String[] lookupKeys;
    //ID map for quick access
    private static final Map<Integer, SpawnableItem> ids = new HashMap<Integer, SpawnableItem>();
    
    //Name map for quick access
    private static final Map<String, SpawnableItem> lookup = new LinkedHashMap<String, SpawnableItem>();
    
    static {
    	for(SpawnableItem item : EnumSet.allOf(SpawnableItem.class)){
    		ids.put(item.id, item);
    		for(String key : item.lookupKeys){
    			lookup.put(key, item);
    		}
    	}
    }
    
    SpawnableItem(int id, String name, String lookupKey){
    	this.id = id;
    	this.name = name;
    	this.lookupKeys = new String[] { lookupKey };
    }
    
    SpawnableItem(int id, String name, String... lookupKeys){
    	this.id = id;
    	this.name = name;
    	this.lookupKeys = lookupKeys;
    }
    
    public static SpawnableItem fromID(int id){
    	return ids.get(id);
    }
    
    public static String toName(int id){
    	SpawnableItem item = ids.get(id);
    	if(item != null){ return item.getName(); }
    	else { /* return "#" + id; */ throw new CommandException("[EE] This item is not supported by Equal Exchange."); } //Hopefully stops an NPE that would occur if an item is not supported
    }
    
    public static SpawnableItem lookup(String name){
    	return lookup(name, true);
    }
    
    public static SpawnableItem lookup(String name, boolean fuzzy){
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
    
    //Data handle
    private static final Set<Integer> usesData = new HashSet<Integer>();
    static{
    	usesData.add(SpawnableID.SAPLING);
        usesData.add(SpawnableID.LOG);
        usesData.add(SpawnableID.LEAVES);
        usesData.add(SpawnableID.DISPENSER);
        usesData.add(SpawnableID.POWERED_RAIL);
        usesData.add(SpawnableID.DETECTOR_RAIL);
        usesData.add(SpawnableID.LONG_GRASS);
        usesData.add(SpawnableID.CLOTH);
        usesData.add(SpawnableID.STEP);
        usesData.add(SpawnableID.TORCH);
        usesData.add(SpawnableID.WOODEN_STAIRS);
        usesData.add(SpawnableID.CHEST);
        usesData.add(SpawnableID.FURNACE);
        usesData.add(SpawnableID.LADDER);
        usesData.add(SpawnableID.MINECART_TRACKS);
        usesData.add(SpawnableID.COBBLESTONE_STAIRS);
        usesData.add(SpawnableID.LEVER);
        usesData.add(SpawnableID.STONE_PRESSURE_PLATE);
        usesData.add(SpawnableID.WOODEN_PRESSURE_PLATE);
        usesData.add(SpawnableID.REDSTONE_TORCH_ON);
        usesData.add(SpawnableID.STONE_BUTTON);
        usesData.add(SpawnableID.CACTUS);
        usesData.add(SpawnableID.JUKEBOX);
        usesData.add(SpawnableID.PUMPKIN);
        usesData.add(SpawnableID.JACKOLANTERN);
        usesData.add(SpawnableID.TRAP_DOOR);
        usesData.add(SpawnableID.STONE_BRICK);
        usesData.add(SpawnableID.RED_MUSHROOM_CAP);
        usesData.add(SpawnableID.BROWN_MUSHROOM_CAP);
        usesData.add(SpawnableID.VINE);
        usesData.add(SpawnableID.FENCE_GATE);
        usesData.add(SpawnableID.BRICK_STAIRS);
        usesData.add(SpawnableID.STONE_BRICK_STAIRS);
        usesData.add(SpawnableID.NETHER_BRICK_STAIRS);
        usesData.add(SpawnableID.ENCHANTMENT_TABLE);
        usesData.add(SpawnableID.BREWING_STAND);
        usesData.add(SpawnableID.CAULDRON);
    }
    
    public static boolean usesData(int id){
    	return usesData.contains(id);
    }
    
    public boolean usesData(){
    	return usesData.contains(id);
    }
}
