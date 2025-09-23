package com.mafuyu404.taczaddon.mixin;

import com.mafuyu404.taczaddon.common.LiberateAttachment;
import com.mafuyu404.taczaddon.init.RuleRegistry;
import com.tacz.guns.api.item.attachment.AttachmentType;
import com.tacz.guns.network.message.ClientMessageRefitGun;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.network.NetworkEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(value = ClientMessageRefitGun.class, remap = false)
public abstract class ClientMessageRefitGunMixin {
    @ModifyVariable(method = "lambda$handle$0", at = @At("STORE"), ordinal = 0)
    private static Inventory modifyInventory(Inventory inventory) {
        return LiberateAttachment.useVirtualInventory(inventory);
    }

//    @Inject(method = "<init>", at = @At("TAIL"))
//    private void aaa(int attachmentSlotIndex, int gunSlotIndex, AttachmentType attachmentType, CallbackInfo ci) {
//        System.out.print(attachmentSlotIndex + "/" + gunSlotIndex + "\n");
//    }
}
