package nerdhub.infinityfix;

import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MixinConfig implements IMixinConfigPlugin {

    private static  final String packageName = "nerdhub.infinityfix";

    @Override
    public void onLoad(String mixinPackage) {
        if(!packageName.equals(mixinPackage)){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {

        if(!FabricLoader.getInstance().isDevelopmentEnvironment()){
            return !mixinClassName.equals(packageName + ".MixinEnchantmentTarget");
        }else {
            return !mixinClassName.equals(packageName + ".MixinEnchantmentTargetDev");

        }
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return Collections.emptyList();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}



