package com.davigj.bury_me_deep.core.other.compat;

import net.neoforged.fml.ModList;

public class BMDModConstants {
    public final static boolean ATMOSPHERIC = ModList.get().isLoaded("atmospheric");
    public final static boolean JNE = ModList.get().isLoaded("netherexp");
    public final static boolean SPECIES = ModList.get().isLoaded("species");
    public final static boolean SPAWN = ModList.get().isLoaded("spawn");
    public final static boolean WINDSWEPT = ModList.get().isLoaded("windswept");
    public final static boolean AA = ModList.get().isLoaded("abundant_atmosphere");
}
