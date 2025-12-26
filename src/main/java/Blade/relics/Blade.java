package Blade.relics;

import basemod.abstracts.CustomRelic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.stances.AbstractStance;

import Blade.powers.AWEPower;
import Blade.powers.PERSISTENCEPower;

public class Blade extends CustomRelic {
    public static final String ID = "Blade";
    private static final String IMG = "img/Blade_relics/Blade.png";
    private static final String IMG_OTL = "img/Blade_relics/outline/Blade.png";
    
    //调用父类的构造方法，传参为super(遗物ID,遗物全图，遗物白底图，遗物稀有度，获得遗物时的音效)
    public Blade() {
        super(ID, ImageMaster.loadImage(IMG), ImageMaster.loadImage(IMG_OTL), RelicTier.RARE, AbstractRelic.LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public void onChangeStance(AbstractStance prev, AbstractStance next) {
    if (prev.ID.equals("Wrath")) {
        addToBot(new RemoveSpecificPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            "AWE"
        ));
    }
    if (next.ID.equals("Wrath")) {
        flash();
        addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        addToBot(new ApplyPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            new PERSISTENCEPower(AbstractDungeon.player)
        ));
        addToBot(new ApplyPowerAction(
            AbstractDungeon.player,
            AbstractDungeon.player,
            new AWEPower(AbstractDungeon.player)
        ));
        }
    }

    @Override
    public AbstractRelic makeCopy() {
        return (AbstractRelic)new Blade();
    }
}