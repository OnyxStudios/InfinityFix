package nerdhub.infinityfix;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BaseBowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BaseBowItem.class)
public class MixinBaseBowItem {

    @Inject(method = "findArrowStack", at = @At(value = "HEAD") , cancellable = true)
    private void findArrowStack(PlayerEntity playerEntity_1, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack mainStack = playerEntity_1.getMainHandStack();
        ItemStack offStack = playerEntity_1.getOffHandStack();

        if (mainStack.getItem() instanceof BaseBowItem) {
            if (EnchantmentHelper.getLevel(Enchantments.INFINITY, mainStack) > 0) {
                cir.setReturnValue(new ItemStack(Items.ARROW));
            }
        } else if (offStack.getItem() instanceof BaseBowItem) {
            if (EnchantmentHelper.getLevel(Enchantments.INFINITY, offStack) > 0) {
                cir.setReturnValue(new ItemStack(Items.ARROW));
            }
        }
    }

}
