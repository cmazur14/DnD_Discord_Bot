package com.thegingerbeardd.dndbot;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypesTest;
import com.thegingerbeardd.dndbot.parsing.FifthEditionCommandParserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        AbilityTypesTest.class,
        FifthEditionCommandParserTest.class
})
public class TestSuite {
    //empty class that must exist
}
