package net.lstwo.elemental_tools.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lstwo.elemental_tools.FullItem;
import net.lstwo.elemental_tools.item.axe.AirAxe;
import net.lstwo.elemental_tools.item.axe.EarthAxe;
import net.lstwo.elemental_tools.item.axe.FireAxe;
import net.lstwo.elemental_tools.item.axe.WaterAxe;
import net.lstwo.elemental_tools.item.pickaxe.AirPickaxe;
import net.lstwo.elemental_tools.item.pickaxe.EarthPickaxe;
import net.lstwo.elemental_tools.item.pickaxe.FirePickaxe;
import net.lstwo.elemental_tools.item.pickaxe.WaterPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    static List<FullItem> itemList = new ArrayList<>();

        // Pickaxes
    public static final Item FIRE_PICKAXE = createCustomItem("fire_pickaxe", new FirePickaxe(ToolMaterials.DIAMOND));
    public static final Item FIRE_AXE = createCustomItem("fire_axe", new FireAxe(ToolMaterials.DIAMOND));

    public static final Item WATER_PICKAXE = createCustomItem("water_pickaxe", new WaterPickaxe(ToolMaterials.GOLD));
    public static final Item WATER_AXE = createCustomItem("water_axe", new WaterAxe(ToolMaterials.GOLD));

    public static final Item EARTH_PICKAXE = createCustomItem("earth_pickaxe", new EarthPickaxe(ToolMaterials.IRON));
    public static final Item EARTH_AXE = createCustomItem("earth_axe", new EarthAxe(ToolMaterials.IRON));

    public static final Item AIR_PICKAXE = createCustomItem("air_pickaxe", new AirPickaxe(ToolMaterials.DIAMOND));
    public static final Item AIR_AXE = createCustomItem("air_axe", new AirAxe(ToolMaterials.DIAMOND));


    public static Item createItem(String name, FabricItemSettings itemSettings) {
        Item item = new Item(itemSettings);
        itemList.add(new FullItem(item, name));
        return item;
    }

    public static Item createCustomItem(String name, Item item) {
        itemList.add(new FullItem(item, name));
        return item;
    }

    public static void registerItems() {
        for(FullItem item : itemList) {
            Registry.register(Registry.ITEM, new Identifier("elemental_tools", item.getName()), item.getItem());
        }
    }
}
