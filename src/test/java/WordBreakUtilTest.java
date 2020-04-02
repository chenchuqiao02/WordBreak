import junit.textui.TestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.enums.WorkBreakTypeEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestRunner.class)
public class WordBreakUtilTest {

    @Test
    public void testWordBreak(){
        WordBreakUtil.wordBreakPattern(WorkBreakTypeEnum.FIXED_DICTIONARY,null,"ilikesamsungmobile");
        WordBreakUtil.wordBreakPattern(WorkBreakTypeEnum.FIXED_DICTIONARY,null,"ilikeicecreamandmango");
    }

    @Test
    public void testStage2(){
        String[] userDict = {"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};
        WordBreakUtil.wordBreakPattern(WorkBreakTypeEnum.USER_DICTIONARY,userDict,"ilikesamsungmobile");
    }

    @Test
    public void testStage3(){
        String[] userDict = {"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};
        WordBreakUtil.wordBreakPattern(WorkBreakTypeEnum.BOTH,userDict,"ilikeicecreamandmango");
        WordBreakUtil.wordBreakPattern(WorkBreakTypeEnum.BOTH,userDict,null);

    }
}
