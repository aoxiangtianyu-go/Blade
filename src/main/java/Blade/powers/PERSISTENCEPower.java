package Blade.powers;

import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class PERSISTENCEPower extends AbstractPower{
    public static final String POWER_ID = "PERSISTENCE";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public PERSISTENCEPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.DEBUFF;
    
        this.amount = -1;

        String Path84 = "img/Blade_powers/PERSISTENCE84.png";
        String Path32 = "img/Blade_powers/PERSISTENCE32.png";
        this.region128 = new AtlasRegion(ImageMaster.loadImage(Path84), 0, 0, 84, 84);
        this.region48 = new AtlasRegion(ImageMaster.loadImage(Path32), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void updateDescription() { 
        this.description = DESCRIPTIONS[0];
    }
}