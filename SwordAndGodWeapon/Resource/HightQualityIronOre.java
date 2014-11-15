package com.YIKE.SwordAndGodWeapon.Resource;

import java.util.Random;

import com.YIKE.SwordAndGodWeapon.SwordAndGodWeapon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HightQualityIronOre extends Block{
   public HightQualityIronOre(Material material) {
   super(material);
   
   setBlockName("hightQualityIronOre");
   setBlockTextureName("swordandgodweapon:hightqualityiron_ore");
   setCreativeTab(CreativeTabs.tabBlock);
   setStepSound(Block.soundTypeStone);
   setHarvestLevel("ItemAxe", 3);
   setHardness(4.0F);
   setResistance(10.0f); 
 }
   
   @Override
   public Item getItemDropped(int metadata, Random random, int fortune) {
	return Item.getItemFromBlock(SwordAndGodWeapon.hightQualityIronOre);   
   }
  
   
   
}
