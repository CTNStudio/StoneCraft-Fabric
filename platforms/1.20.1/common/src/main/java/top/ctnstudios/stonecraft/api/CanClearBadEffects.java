package top.ctnstudios.stonecraft.api;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class CanClearBadEffects extends Item {
    public CanClearBadEffects(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            user.removeStatusEffect(StatusEffects.SLOWNESS);
            user.removeStatusEffect(StatusEffects.INSTANT_DAMAGE);
            user.removeStatusEffect(StatusEffects.NAUSEA);
            user.removeStatusEffect(StatusEffects.BLINDNESS);
            user.removeStatusEffect(StatusEffects.HUNGER);
            user.removeStatusEffect(StatusEffects.WEAKNESS);
            user.removeStatusEffect(StatusEffects.POISON);
            user.removeStatusEffect(StatusEffects.WITHER);
            user.removeStatusEffect(StatusEffects.LEVITATION);
            user.removeStatusEffect(StatusEffects.UNLUCK);
            user.removeStatusEffect(StatusEffects.DARKNESS);
        }
        return stack;
    }
}
