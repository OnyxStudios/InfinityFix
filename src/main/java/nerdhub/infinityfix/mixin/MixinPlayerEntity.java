package nerdhub.infinityfix.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {

    @Inject(method = "getArrowType", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;abilities:Lnet/minecraft/entity/player/PlayerAbilities;"), cancellable = true)
    private void getArrowType(ItemStack weapon, CallbackInfoReturnable<ItemStack> cir) {
        if(EnchantmentHelper.getLevel(Enchantments.INFINITY, weapon) > 0) {
            cir.setReturnValue(new ItemStack(Items.ARROW));
        }
    }
}
