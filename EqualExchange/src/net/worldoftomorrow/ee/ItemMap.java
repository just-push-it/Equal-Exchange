package net.worldoftomorrow.ee;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;

import net.worldoftomorrow.ee.ConfigurationManager.ConfigFile;

public class ItemMap {
	private static final Map<String, Object> values = new HashMap<String, Object>();
	
	public static void readItems(){
		values.clear();
    	values.putAll(ConfigurationManager.getConfig(ConfigFile.ITEMS).getConfigurationSection("Items").getValues(false));
    	}
	
	public enum Items{
	    FERN(Material.DEAD_BUSH.getId(), 2),
	    LONGGRASS(Material.DEAD_BUSH.getId(), 1),
	    VINE(Material.VINE.getId()),
	    DEADBUSH(Material.DEAD_BUSH.getId()),
	    DIRT(Material.DIRT.getId()),
	    GLASS(Material.GLASS.getId()),
	    GRASS(Material.GRASS.getId()),
	    ICE(Material.ICE.getId()),
	    OAKLEAVES(Material.LEAVES.getId()),
	    PINELEAVES(Material.LEAVES.getId(), 1),
	    BIRCHLEAVES(Material.LEAVES.getId(), 2),
	    JUNGLELEAVES(Material.LEAVES.getId(), 3),
	    MYCELLIUM(Material.MYCEL.getId()),
	    NETHERRACK(Material.NETHERRACK.getId()),
	    BUTTON(Material.STONE_BUTTON.getId()),
	    GRAVEL(Material.GRAVEL.getId()),
	    NETHERBRICK(Material.NETHER_BRICK.getId()),
	    LEVER(Material.LEATHER.getId()),
	    CACTUS(Material.CACTUS.getId()),
	    FURNACE(Material.FURNACE.getId()),
	    WOOD(Material.WOOD.getId()),
	    TORCH(Material.TORCH.getId()),
	    WEB(Material.WEB.getId()),
	    FENCE(Material.FENCE.getId()),
	    FISHINGROD(Material.FISHING_ROD.getId()),
	    STRING(Material.STRING.getId()),

	    LADDER(Material.LADDER.getId()),
	    ARROW(Material.ARROW.getId()),
	    FLOWER(Material.YELLOW_FLOWER.getId()),
	    ROSE(Material.RED_ROSE.getId()),
	    LILYPAD(Material.WATER_LILY.getId()),

	    SEEDS(Material.SEEDS.getId()),
	    MELONSEEDS(Material.MELON_SEEDS.getId()),
	    WHEAT(Material.WHEAT.getId()),
	    TRAPDOOR(Material.TRAP_DOOR.getId()),
	    CHARCOAL(Material.COAL.getId(), 1),
	    CRAFTINGTABLE(Material.WORKBENCH.getId()),
	    FENCEGATE(Material.FENCE_GATE.getId()),
	    REDMUSHROOM(Material.RED_MUSHROOM.getId()),
	    BROWNMUSHROOM(Material.BROWN_MUSHROOM.getId()),
	    SAPLING(Material.SAPLING.getId()), //TODO: Need all the sapling types
	    SUGARCANE(Material.SUGAR_CANE.getId()),
	    PAPER(Material.PAPER.getId()),
	    SUGAR(Material.SUGAR.getId()),
	    BONEMEAL(Material.INK_SACK.getId(), 15), //TODO: Need the other colors too
	    WOOL(Material.WOOL.getId()), //TODO: Need the other colors too
	    SOULSAND(Material.SOUL_SAND.getId()),
	    CHEST(Material.CHEST.getId()),
	    OBSIDIAN(Material.OBSIDIAN.getId()),
	    REDSTONE(Material.REDSTONE.getId()),
	    PORKCHOP(Material.PORK.getId()), //TODO: Cooked and uncooked
	    BEEF(Material.RAW_BEEF.getId()), //TODO: Cooked and uncooked
	    FISH(Material.RAW_FISH.getId()), //TODO: Cooked and uncooked
	    CHICKEN(Material.RAW_CHICKEN.getId()), //TODO: Cooked and uncooked
	    LEATHER(Material.LEATHER.getId()),
	    CLAY(Material.CLAY_BALL.getId()),
	    REDSTONETORCH(Material.REDSTONE_TORCH_ON.getId()),
	    BREAD(Material.BREAD.getId()),
	    PAINTING(Material.PAINTING.getId()),
	    RAIL(Material.RAILS.getId()),
	    BOOK(Material.BOOK.getId()),
	    BONE(Material.BONE.getId()),
	    DISPENSER(Material.DISPENSER.getId()),
	    COAL(Material.COAL.getId()),
	    NOTEBLOCK(Material.NOTE_BLOCK.getId()),
	    SPIDEREYE(Material.SPIDER_EYE.getId()),
	    JACKOLANTERN(Material.JACK_O_LANTERN.getId()), 
	    MELON(Material.MELON.getId()), 
	    PUMPKIN(Material.PUMPKIN.getId()), 
	    BED(Material.BED.getId()), 
	    MOSSSTONE(Material.MOSSY_COBBLESTONE.getId()),
	    GUNPOWDER(Material.SULPHUR.getId()),
	    FERMENTEDSPIDEREYE(Material.FERMENTED_SPIDER_EYE.getId()),
	    GLISTENINGMELON(Material.SPECKLED_MELON.getId()),
	    BRICKBLOCK(Material.BRICK.getId()),
	    BRICKSLAB(Material.STEP.getId(), 4),
	    CLAYBLOCK(Material.CLAY.getId()),
	    DETECTORRAIL(Material.DETECTOR_RAIL.getId()),
	    BOOKSHELF(Material.BOOKSHELF.getId()),
	    BRICKSTAIRS(Material.BRICK_STAIRS.getId()),
	    PISTON(33),
	    STICKYPISTON(29),
	    CAKE(Material.CAKE.getId()),
	    GLOWSTONEDUST(Material.GLOWSTONE_DUST.getId()),
	    BLAZEPOWDER(Material.BLAZE_POWDER.getId()),
	    BUCKET(Material.BUCKET.getId()),
	    WATERBUCKET(Material.WATER_BUCKET.getId()),
	    MAGMACREAM(Material.MAGMA_CREAM.getId()),
	    LAVABUCKET(Material.LAVA_BUCKET.getId()),
	    MILK(Material.MILK_BUCKET.getId()),
	    LAPISLAZULI(Material.INK_SACK.getId(), 4),
	    TNT(Material.TNT.getId()),
	    ENDERPEARL(Material.ENDER_PEARL.getId()),
	    COMPASS(Material.COMPASS.getId()),
	    MINECART(Material.MINECART.getId()),
	    FURNACEMINECART(Material.POWERED_MINECART.getId()),
	    CHESTCART(Material.STORAGE_MINECART.getId()),
	    GLOWSTONE(Material.GLOWSTONE.getId()),
	    BLAZEROD(Material.BLAZE_ROD.getId()),
	    BREWINGSTAND(Material.BREWING_STAND_ITEM.getId()),
	    EYEOFENDER(Material.EYE_OF_ENDER.getId()),
	    POWEREDRAIL(Material.POWERED_RAIL.getId()),
	    GHASTTEAR(Material.GHAST_TEAR.getId()),
	    LAPISLAZULIBLOCK(Material.LAPIS_BLOCK.getId()),
	    JUKEBOX(Material.JUKEBOX.getId()),
	    ENCHANTMENTTABLE(Material.ENCHANTMENT_TABLE.getId()),
	    //Wood
	    STICK(Material.STICK.getId()),
	    WOOD_PLATE(Material.WOOD_PLATE.getId()),
	    WOOD_STAIRS(Material.WOOD_STAIRS.getId()),
	    WOOD_SLAB(Material.STEP.getId(), 2),
	    //Sand | Sandstone
	    SAND(Material.SAND.getId()),
	    SANDSTONE(Material.SANDSTONE.getId()),
	    SANDSTONE_SLAB(Material.STEP.getId(), 1), //TODO: Add the new sandstone blocks from 1.2.4
	    //Stone | Cobblestone
	    STONE(Material.STONE.getId()),
	    STONE_PICKAXE(Material.STONE_PICKAXE.getId()),
	    STONE_AXE(Material.STONE_AXE.getId()),
	    STONE_SHOVEL(Material.STONE_SPADE.getId()),
	    STONE_SWORD(Material.STONE_SWORD.getId()),
	    STONE_HOE(Material.STONE_HOE.getId()),
	    STONE_PLATE(Material.STONE_PLATE.getId()),
	    STONE_SLAB(Material.STEP.getId()),
	    COBBLESTONE(Material.COBBLESTONE.getId()),
	    COBBLESTONE_SLAB(Material.STEP.getId(), 3),
	    COBBLESTONE_STAIRS(Material.COBBLESTONE_STAIRS.getId()),
	    //Iron
	    IRON(Material.IRON_INGOT.getId()),
	    IRON_ORE(Material.IRON_ORE.getId()),
	    IRON_BLOCK(Material.IRON_BLOCK.getId()), 
	    IRON_PICKAXE(Material.IRON_PICKAXE.getId()),
	    IRON_AXE(Material.IRON_AXE.getId()),
	    IRON_SHOVEL(Material.IRON_SPADE.getId()),
	    IRON_HOE(Material.IRON_HOE.getId()),
	    IRON_SWORD(Material.IRON_SWORD.getId()),
	    IRON_HELMET(Material.IRON_HELMET.getId()),
	    IRON_CHESTPLATE(Material.IRON_CHESTPLATE.getId()),
	    IRON_LEGGINGS(Material.IRON_LEGGINGS.getId()),
	    IRON_BOOTS(Material.IRON_BOOTS.getId()),
	    IRON_BARS(Material.IRON_FENCE.getId()),
	    IRON_DOOR(Material.IRON_DOOR.getId()),
	    //Gold
	    GOLD(Material.GOLD_INGOT.getId()),
	    GOLD_NUGGET(Material.GOLD_NUGGET.getId()),
	    GOLD_BLOCK(Material.GOLD_BLOCK.getId()),
	    GOLD_ORE(Material.GOLD_ORE.getId()),
	    GOLD_PICKAXE(Material.GOLD_PICKAXE.getId()),
	    GOLD_AXE(Material.GOLD_AXE.getId()),
	    GOLD_SHOVEL(Material.GOLD_SPADE.getId()),
	    GOLD_HOE(Material.GOLD_HOE.getId()),
	    GOLD_SWORD(Material.GOLD_SWORD.getId()),
	    GOLD_HELMET(Material.GOLD_HELMET.getId()),
	    GOLD_CHESTPLATE(Material.GOLD_CHESTPLATE.getId()),
	    GOLD_LEGGINGS(Material.GOLD_LEGGINGS.getId()),
	    GOLD_BOOTS(Material.GOLD_BOOTS.getId()),
	    //Diamond
	    DIAMOND(Material.DIAMOND.getId()),
	    DIAMOND_BLOCK(Material.DIAMOND_BLOCK.getId()),
	    DIAMOND_SWORD(Material.DIAMOND_SWORD.getId()),
	    DIAMOND_HOE(Material.DIAMOND_HOE.getId()),
	    DIAMOND_SHOVEL(Material.DIAMOND_SPADE.getId()),
	    DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE.getId()),
	    DIAMOND_AXE(Material.DIAMOND_AXE.getId()),
	    DIAMOND_BOOTS(Material.DIAMOND_BOOTS.getId()),
	    DIAMOND_HELMET(Material.DIAMOND_HELMET.getId()),
	    DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS.getId()),
	    DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE.getId());
	    //TODO: Get all the other ones I am missing. Which is a lot.
	    //TODO: Add the names for items.yml reference.
	    
	    private int id;
	    private int data;
	    private Items(int id, int data){
	    	this.id = id;
	    	this.data = data;
	    }
	    
	    private Items(int id){
	    	this.id = id;
	    	this.data = 0;
	    }
	}
}
