package top.ctnstudios.registry.ToolMaterials;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static top.ctnstudios.registry.Items.LV1STONE_ITEM;

public class lv1ToolMaterial implements ToolMaterial {
    public static final lv1ToolMaterial INSTANCE = new lv1ToolMaterial();
    @Override
    public int getDurability() {
        return 175;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }
    @Override
    public float getAttackDamage() {
        return 1.5F;
    }
    @Override
    public int getMiningLevel() {
        return MiningLevels.STONE;
    }
    @Override
    public int getEnchantability() {
        return 7;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(LV1STONE_ITEM);
    }
}