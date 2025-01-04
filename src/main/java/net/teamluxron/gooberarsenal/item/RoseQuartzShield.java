package net.teamluxron.gooberarsenal.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.math.Vec3d;

import java.util.List;
import java.util.function.Consumer;

public class RoseQuartzShield extends ShieldItem {
    public RoseQuartzShield(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void damage(ItemStack stack, int amount, LivingEntity entity, Consumer<LivingEntity> breakCallback) {
        super.damage(stack, amount, entity, breakCallback);

        if (entity instanceof PlayerEntity player) {
            // Check if the shield blocked the hit
            if (player.isBlocking()) {
                // 10% chance to trigger knockback
                if (player.getRandom().nextFloat() < 0.1) {
                    // Apply knockback to nearby entities
                    List<Entity> nearbyEntities = player.getWorld().getOtherEntities(player,
                            player.getBoundingBox().expand(3), e -> e instanceof LivingEntity);

                    for (Entity target : nearbyEntities) {
                        if (target instanceof LivingEntity livingTarget) {
                            Vec3d knockbackDirection = livingTarget.getPos().subtract(player.getPos()).normalize();
                            livingTarget.addVelocity(knockbackDirection.x * 2, 1.5, knockbackDirection.z * 2);
                            livingTarget.velocityModified = true;
                        }
                    }
                }
            }
        }
    }
}