package com.thegingerbeardd.dndbot.generator;

import com.thegingerbeardd.dndbot.character.Character;
import com.thegingerbeardd.dndbot.character.RollModifierCalculator;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;
import com.thegingerbeardd.dndbot.dice.Die;
import org.apache.commons.lang3.StringUtils;

public class SavingThrowResponseGenerator {

    private static final Die d20 = new Die(20);

    public static String generateSavingThrowResult(Character ch, AbilityTypes ability) {
        int mod = RollModifierCalculator.getInstance().getSavingThrowModifier(ability, ch);
        return new StringBuilder()
                .append(ch.getName())
                .append(" rolls a **")
                .append(d20.roll(mod)).append("**")
                .append(" on their ")
                .append(StringUtils.capitalize(ability.name().toLowerCase()))
                .append(" saving throw!")
                .toString();
    }

}
