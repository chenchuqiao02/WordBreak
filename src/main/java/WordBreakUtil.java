import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pojo.enums.WorkBreakTypeEnum;

import java.util.*;

/**
 * workBreak
 * @author Jo
 * @date 2020/04/01
 */
public class WordBreakUtil {

    /**
     * 根据规则打印字符串
     * @param workBreakTypeEnum 字典类型
     * @param userDict 用户字典
     * @param s 输入内容
     */
    public static void wordBreakPattern(WorkBreakTypeEnum workBreakTypeEnum, String[] userDict, String s){
        //如果输入内容为空，直接提示
        if(StringUtils.isEmpty(s)){
            System.out.println("输入内容为空");
            return;
        }
        //固定字典
        String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man go"};
        ArrayList<String> al = new ArrayList<String>();

        //固定字典
        if(WorkBreakTypeEnum.FIXED_DICTIONARY.equals(workBreakTypeEnum)){
            wordBreak(s, al, dict);
            //用户字典
        } else if(WorkBreakTypeEnum.USER_DICTIONARY.equals(workBreakTypeEnum)){
            wordBreak(s, al, userDict);
            //两个字典都使用
        } else if(WorkBreakTypeEnum.BOTH.equals(workBreakTypeEnum)){
            List<String> bothDict = Arrays.asList(userDict);
            List<String> list = new ArrayList<>(bothDict);
            List<String> fixedDict = Arrays.asList(dict);
           fixedDict.forEach(word->{
               if(!list.contains(word)){
                   list.add(word);
               }
           });
            String[] newDict = list.toArray(new String[list.size()]);
            wordBreak(s, al, newDict);
        }

    }

    /**
     * 分词
     * @param s 输入内容
     * @param al 需打印数组
     * @param dict 使用的字典
     */
    public static void wordBreak(String s, ArrayList<String> al, String[] dict){
        int len = s.length();
        //如果需匹配的字符串长度为0并且需打印内容不为空
        if(len == 0 && !CollectionUtils.isEmpty(al)){
            StringBuilder sb = new StringBuilder();
        al.forEach(word-> sb.append(word).append(" ")
        );
            System.out.println(sb.toString());
            return;
        }

        //匹配字典
        for(int i=1; i<=len; i++){
            String substr = s.substring(0, i);
            Map<Boolean, String> map = getDictionaryContains(substr, dict);
            if(map.containsKey(true)){
                al.add(map.get(true));
                wordBreak(s.substring(i), al, dict);
                al.remove(al.size()-1);
            }
        }
    }

    /**
     * 与字典匹配
     * @param word  需匹配的字符串
     * @param dict 使用的字典
     * @return  Map<Boolean, String> 结果集
     */
    private static Map<Boolean, String> getDictionaryContains(String word,String[] dict){
        Map<Boolean, String> map = new HashMap<>();
        for(int i=0; i<dict.length; i++){
            if(dict[i].replace(" ","").equals(word)){
                map.put(true,dict[i]);
                return map;
            }
        }
        map.put(false,null);
        return map;
    }

}
