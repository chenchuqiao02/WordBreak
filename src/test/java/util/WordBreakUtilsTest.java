package util;

import junit.textui.TestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.enums.DictionaryTypeEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestRunner.class)
public class WordBreakUtilsTest {

    @Test
    public void testWordBreak(){
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.FIXED_DICTIONARY,null,"ilikesamsungmobile");
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.FIXED_DICTIONARY,null,"ilikeicecreamandmango");
    }

    @Test
    public void testStage2(){
        String[] userDict = {"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango","and"};
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.USER_DICTIONARY,userDict,"ilikesamsungmobile");
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.USER_DICTIONARY,userDict,"ilikeicecreamandmango");


    }

    @Test
    public void testStage3(){
        String[] userDict = {"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.BOTH,userDict,"ilikesamsungmobile");
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.BOTH,userDict,"ilikeicecreamandmango");
        WordBreakUtils.printWordBreak(DictionaryTypeEnum.BOTH,userDict,null);

    }
}
