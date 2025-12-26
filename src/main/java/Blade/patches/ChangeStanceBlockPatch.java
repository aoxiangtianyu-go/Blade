package Blade.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import javassist.CannotCompileException;
import javassist.CtBehavior;

@SpirePatch(
    clz = ChangeStanceAction.class,
    method = "update"
)
public class ChangeStanceBlockPatch {

    @SpireInsertPatch(
        locator = Locator.class
    )
    public static SpireReturn<Void> insert(ChangeStanceAction __instance) {
        if (AbstractDungeon.player != null &&
            AbstractDungeon.player.hasPower("PERSISTENCE")) {
            __instance.isDone = true;
            return SpireReturn.Return();
        }
        return SpireReturn.Continue();
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethod)
                throws CannotCompileException, PatchingException {

            Matcher finalMatcher =
                new Matcher.FieldAccessMatcher(
                    AbstractPlayer.class,
                    "stance"
                );

            return LineFinder.findInOrder(ctMethod, finalMatcher);
        }
    }
}
