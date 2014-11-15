package com.YIKE.SwordAndGodWeapon.Handler;

import java.util.Random;

import com.YIKE.SwordAndGodWeapon.SwordAndGodWeapon;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SwordAndGodWeaponGenerator implements IWorldGenerator{
	
  
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	
		if(world.provider.dimensionId == 0) {
		for (int i = 0; i < 7; i++) { // means set i = 0, then if its less than 25 keep adding one to i
			int randPosX = chunkX * 16 + random.nextInt(16);
			int randPosY = random.nextInt(35) + 10;
			int randPosZ = chunkZ * 16 + random.nextInt(16);
		//疑问 chunkX 和chunkZ如果不乘 16的话基本找不到
	     
	    (new WorldGenMinable(SwordAndGodWeapon.hightQualityIronOre, 5)).generate(world, random, randPosX, randPosY, randPosZ);
		
	    } 
			        
	  }
	}	
		
}
