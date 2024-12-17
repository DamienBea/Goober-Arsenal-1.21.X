package net.teamluxron.gooberarsenal.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

//public class BananadeProjectileEntity extends ThrownItemEntity {
//    public BananadeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public BananadeProjectileEntity(LivingEntity livingEntity, World world) {
//        super(, livingEntity, world);
//    }

//    @Override
//    protected Item getDefaultItem() {
//        return;
//    }
//
//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return new EntitySpawnS2CPacket(this);
//    }

//    @Override
//    protected void onBlockHit(BlockHitResult blockHitResult) {
//        if (this.getWorld().isClient()) {
//            this.getWorld().sendEntityStatus(this, (byte) 3);
//            this.getWorld().createExplosion(this, 0, 0, 0, 5, World.ExplosionSourceType.TNT);
//        }
//        ;
//        this.discard();
//        super.onBlockHit(blockHitResult);
//
//    }
//}
