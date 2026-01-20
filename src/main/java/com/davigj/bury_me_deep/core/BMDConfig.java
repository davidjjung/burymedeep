//package com.davigj.bury_me_deep.core;
//
//import net.minecraftforge.common.ForgeConfigSpec;
//import net.neoforged.neoforge.common.ModConfigSpec;
//import org.apache.commons.lang3.tuple.Pair;
//
//public class BMDConfig {
//    public static class Common {
////        public final ForgeConfigSpec.ConfigValue<Boolean> configExists;
//
//        Common (ForgeConfigSpec.Builder builder) {
//            builder.push("changes");
////            configExists = builder.comment("Does the template config exist").define("Config exists", true);
//            builder.pop();
//        }
//    }
//
//    static final ModConfigSpec COMMON_SPEC;
//    public static final BMDConfig.Common COMMON;
//
//
//    static {
//        Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
//        COMMON_SPEC = (ModConfigSpec) commonSpecPair.getRight();
//        COMMON = (Common) commonSpecPair.getLeft();
//    }
//}
