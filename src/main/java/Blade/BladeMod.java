package Blade;

 import basemod.BaseMod;
 import basemod.helpers.RelicType;
 import basemod.interfaces.*;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
 import com.megacrit.cardcrawl.core.Settings;
 import com.megacrit.cardcrawl.localization.Keyword;
 import com.megacrit.cardcrawl.localization.PowerStrings;
 import com.megacrit.cardcrawl.localization.RelicStrings;
 import com.megacrit.cardcrawl.relics.AbstractRelic;
 import Blade.relics.Blade;

 @SpireInitializer
 public class BladeMod implements EditRelicsSubscriber, EditStringsSubscriber {

   public BladeMod() {
     //构造方法，初始化各种参数
     BaseMod.subscribe((ISubscriber)this);
   }

   //初始化整个MOD,一定不能删掉
   public static void initialize() {
         new BladeMod();
     }

   @Override
   public void receiveEditStrings() {
     //读取遗物，卡牌，能力，药水，事件的JSON文本

     String relic="", power="";
     if (Settings.language == Settings.GameLanguage.ZHS) {
         relic = "localization/Blade_relics-zh.json";
         power = "localization/Blade_powers-zh.json";
     } else {
         //其他语言配置的JSON
          relic = "localization/Blade_relics-en.json";
          power = "localization/Blade_powers-en.json";
     }
     BaseMod.loadCustomStringsFile(RelicStrings.class, relic);
     BaseMod.loadCustomStringsFile(PowerStrings.class, power);
   }

   
   //添加一度
   @Override
   public void receiveEditRelics() {
       //将自定义的遗物添加到这里
       BaseMod.addRelic((AbstractRelic)new Blade(),RelicType.PURPLE);
   }

   class Keywords {
     Keyword[] keywords;
   }
 }