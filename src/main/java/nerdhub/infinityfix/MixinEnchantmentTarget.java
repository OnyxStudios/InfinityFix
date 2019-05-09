package nerdhub.infinityfix;

import net.minecraft.item.BaseBowItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net/minecraft/enchantment/EnchantmentTarget$4")
public class MixinEnchantmentTarget {

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_8177",at = @At("RETURN"),cancellable = true, remap = false)
    private void isBaseBowItem(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValueZ() && item instanceof BaseBowItem) {
            cir.setReturnValue(true);
        }
    }
}