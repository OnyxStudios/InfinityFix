package nerdhub.infinityfix.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.item.BaseBowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class MixinEnchantment {

    @Inject(method = "isAcceptableItem", at = @At("RETURN"), cancellable = true)
    private void isAcceptableItem(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if(!cir.getReturnValueZ() && ((Object) this) instanceof InfinityEnchantment && itemStack.getItem() instanceof BaseBowItem) {
            cir.setReturnValue(true);
        }
    }
}
