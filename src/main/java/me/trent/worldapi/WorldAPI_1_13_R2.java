package me.trent.worldapi;

import org.bukkit.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.List;
import java.util.Random;

public class WorldAPI_1_13_R2 {

    public static void generate(String name){
        World world = WorldCreator.name(name).type(WorldType.FLAT).environment(World.Environment.NORMAL).generator(new Generator()).createWorld();
    }

    public static class Generator extends ChunkGenerator {
        @Override
        public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
            SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
            ChunkData chunk = createChunkData(world);
            generator.setScale(0.005D);
            int currentHeight = 0;

            for (int X = 0; X < 16; X++)
                for (int Z = 0; Z < 16; Z++) {
                    chunk.setBlock(X, currentHeight, Z, Material.AIR);
                    //currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z, 0.5D, 0.5D)*15D+50D);
                    //chunk.setBlock(X, currentHeight, Z, Material.GRASS);
                    //chunk.setBlock(X, currentHeight-1, Z, Material.DIRT);
                    //for (int i = currentHeight-2; i > 0; i--)
                    //    chunk.setBlock(X, i, Z, Material.STONE);
                    //chunk.setBlock(X, 0, Z, Material.BEDROCK);
                }
            return chunk;
        }

        @Override
        public Location getFixedSpawnLocation(World world, Random random) {
            return new Location(world, 0, 100, 0);
        }

        @Override
        public boolean canSpawn(World world, int x, int z) {
            return super.canSpawn(world, x, z);
        }

        @Override
        public List<BlockPopulator> getDefaultPopulators(World world) {
            return super.getDefaultPopulators(world);
        }
    }


}
