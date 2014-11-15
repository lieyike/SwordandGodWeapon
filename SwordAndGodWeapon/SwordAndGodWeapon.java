package com.YIKE.SwordAndGodWeapon;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.YIKE.SwordAndGodWeapon.Handler.SwordAndGodWeaponGenerator;
import com.YIKE.SwordAndGodWeapon.Resource.HightQualityIronIngot;
import com.YIKE.SwordAndGodWeapon.Resource.HightQualityIronOre;
import com.YIKE.SwordAndGodWeapon.Resource.IceSpringWaterBlock;
import com.YIKE.SwordAndGodWeapon.Resource.IceSpringWaterBuckets;
import com.YIKE.SwordAndGodWeapon.Resource.ShadeCore;
import com.YIKE.SwordAndGodWeapon.Sword.ShadeSword;
import com.YIKE.SwordAndGodWeapon.generic.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = SwordAndGodWeapon.MODID, name = SwordAndGodWeapon.NAME, version = SwordAndGodWeapon.VERSION)
public class SwordAndGodWeapon
{
    public static final String MODID = "SwordAndGodWeapon";
    public static final String VERSION = "0.0.1";
    public static final String NAME = "Sword And God Weapon";
    
    @Instance(value = MODID)
    public static SwordAndGodWeapon instance;
    
    @SidedProxy(clientSide = "com.YIKE.SwordAndGodWeapon.generic.client.ClientProxy",
    		    serverSide = "com.YIKE.SwordAndGodWeapon.generic.CommonProxy")
    public static CommonProxy proxy;
    
    public static HightQualityIronOre hightQualityIronOre;
    public static Fluid iceSpringWater;
    public static IceSpringWaterBlock iceSpringWaterBlock;
    public static Item iceSpringWaterBuckets;
    
    public static HightQualityIronIngot hightQualityIronIngot;

    public static ShadeCore shadeCore;
    
    public static ShadeSword shadeSword;
   
    public static CreativeTabs SwordAndGodWeaponTab ;
    
    
    
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event) {	
    	
    	SwordAndGodWeaponTab = new CreativeTabs("SwordAndGodWeaponTab") {
    	    @Override	
    	    @SideOnly(Side.CLIENT)
    	    public Item getTabIconItem() {
    	    	return shadeCore;
    	       }
    	    };
    	
    	hightQualityIronOre = new HightQualityIronOre(Material.iron); 
    	hightQualityIronOre.setCreativeTab(SwordAndGodWeaponTab);
    	GameRegistry.registerBlock(hightQualityIronOre, "hightQualityIronOre");  
    	
    	hightQualityIronIngot = new HightQualityIronIngot();
    	hightQualityIronIngot.setMaxStackSize(64);
    	hightQualityIronIngot.setTextureName("swordandgodweapon:hightqualityiron_ingot");
    	hightQualityIronIngot.setUnlocalizedName("hightQualityIronIngot"); 
    	hightQualityIronIngot.setCreativeTab(SwordAndGodWeaponTab);
    	GameRegistry.registerItem(hightQualityIronIngot, "hightQualityIronIngot");
    	
 
    	shadeCore = new ShadeCore();
    	shadeCore.setMaxStackSize(1);
    	shadeCore.setUnlocalizedName("shadeCore");
    	shadeCore.setTextureName("swordandgodweapon:shade_core");
    	shadeCore.setCreativeTab(SwordAndGodWeaponTab);
    	GameRegistry.registerItem(shadeCore, "shadeCode");
    	
    	shadeSword = new ShadeSword(ToolMaterial.IRON); 
    	shadeSword.setMaxStackSize(1);
    	shadeSword.setUnlocalizedName("shadeSword");
    	shadeSword.setTextureName("swordandgodweapon:shade_sword");
    	shadeSword.setMaxDamage(1200);
    	shadeSword.setCreativeTab(SwordAndGodWeaponTab);
    	GameRegistry.registerItem(shadeSword, "shadeSword"); 
    	
    	iceSpringWater = new Fluid("iceSpringWater");
      	FluidRegistry.registerFluid(iceSpringWater);//注册后iceSpringWater是以小写名记录

    	iceSpringWaterBlock = new IceSpringWaterBlock(iceSpringWater, Material.water);
        iceSpringWaterBlock.setBlockName("iceSpringWaterBlock");
        GameRegistry.registerBlock(iceSpringWaterBlock, "iceSpringWaterBlock");
//        GameRegistry.registerBlock(iceSpringWaterBlock, SwordAndGodWeapon.MODID + "_" +
//                                  iceSpringWaterBlock.getUnlocalizedName().substring(5));
        iceSpringWater.setUnlocalizedName(iceSpringWaterBlock.getUnlocalizedName());
        iceSpringWaterBuckets = new IceSpringWaterBuckets(iceSpringWaterBlock);
        iceSpringWaterBuckets.setUnlocalizedName("iceSpringWaterBuckets");
        iceSpringWaterBuckets.setContainerItem(Items.bucket);
        iceSpringWaterBuckets.setCreativeTab(SwordAndGodWeaponTab);
        GameRegistry.registerItem(iceSpringWaterBuckets, "iceSpringWaterBuckets");  
        FluidContainerRegistry.registerFluidContainer(iceSpringWater, new ItemStack(iceSpringWaterBuckets),
        		                                      new ItemStack(Items.bucket));
        
    
    
    }
    @EventHandler
    public void Load(FMLInitializationEvent event) { 
    	
    	
    	
    GameRegistry.addRecipe(new ItemStack(shadeCore, 1), 
    		               new Object[] {" Y ", "YXY", " Y ", 'Y', 
    	                   Items.ender_pearl, 'X', Items.ender_eye});
 	GameRegistry.addRecipe(new ItemStack(shadeSword, 1), 
 			               new Object[] {" YY", " XY", "Z  ", 'Y',
 		              hightQualityIronIngot, 'X', shadeCore, 'Z', Items.stick});
    //ItemStack()2个铁矿石才能生成1个高级铁矿石
    GameRegistry.addSmelting(hightQualityIronOre, new ItemStack(hightQualityIronIngot, 1), 3f);
     
    GameRegistry.addSmelting(new ItemStack(Items.iron_ingot, 2), new ItemStack(hightQualityIronIngot, 1), 1f);

    GameRegistry.registerWorldGenerator(new SwordAndGodWeaponGenerator(), 2);
    proxy.registerRenderers(); 
    }
    
    @EventHandler
    public static void init(FMLPostInitializationEvent event)
    {
		
    }
}
