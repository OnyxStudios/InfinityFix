package nerdhub.infinityfix.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InfinityEnchantment.class)
public class MixinInfinityEnchantment extends Enchantment {

    protected MixinInfinityEnchantment(Weight weight, EnchantmentTarget target, EquipmentSlot[] applicableSlots) {
        super(weight, target, applicableSlots);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack) || stack.getItem() instanceof RangedWeaponItem;
    }

    @Inject(method = "differs", at = @At("HEAD"), cancellable = true)
    private void differs(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        if(other instanceof MendingEnchantment) cir.setReturnValue(true);
    }
}
