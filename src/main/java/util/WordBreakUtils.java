import org.springframework.util.StringUtils;
import pojo.enums.DictionaryTypeEnum;

import java.util.*;

public class WordBreakUtils {
    /**
     * Print all possible word breaks of the input sentence in different dictionaries
     * @param dictionaryTypeEnum dictionary type
     * @param userDict the dictionary
     * @param input the input sentence
     */
    public static void printWordBreak(DictionaryTypeEnum dictionaryTypeEnum, String[] userDict, String input){
        //if the input sentence is empty
        if(StringUtils.isEmpty(input)){
            System.out.println("the input sentence is empty");
            return;
        }

        //the fixed dictionary
        String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man go"};

        //find in the fixed dictionary
        if(DictionaryTypeEnum.FIXED_DICTIONARY.equals(dictionaryTypeEnum)){
            wordBreak(input, dict);
            //find in the user customized dictionary
        } else if(DictionaryTypeEnum.USER_DICTIONARY.equals(dictionaryTypeEnum)){
            wordBreak(input, userDict);
            //find in both dictionaries
        } else if(DictionaryTypeEnum.BOTH.equals(dictionaryTypeEnum)){
            List<String> bothDict = Arrays.asList(userDict);
            List<String> list = new ArrayList<>(bothDict);
            List<String> fixedDict = Arrays.asList(dict);
            fixedDict.forEach(word->{
                if(!list.contains(word)){
                    list.add(word);
                }
            });
            String[] newDict = list.toArray(new String[list.size()]);
            wordBreak(input, newDict);
        }
    }

    /**
     * Print all possible word breaks of the input sentence
     * @param input the input sentence
     * @param dict the dictionary
     */
    private static void wordBreak(String input, String[] dict ){
        wordBreakUtil(input, input.length(), dict, "");
    }

    /**
     * WordBreakUtil
     * @param input the input sentence
     * @param n the length of the words
     * @param dict the dictionary
     * @param result the print result
     */
    private static void wordBreakUtil(String input, int n, String[] dict, String result) {
        for (int i=1; i<=n; i++){
            String prefix =input.substring(0, i);
            Map<Boolean, String> map = getDictionaryContains(prefix, dict);
            //if (dictionaryContains(prefix, dict)) {
            if (map.containsKey(true)) {
                if (i == n){
                    //result += prefix;
                    result += map.get(true);
                    System.out.println( result);
                    return;
                }
                wordBreakUtil(input.substring(i, n), n-i, dict, result + prefix + " ");
            }
        }
    }

    /**
     * Check whether a word is present in the dictionary or not
     * @param word  word
     * @param dict dictionary
     * @return true or false
     */
//    private static Boolean dictionaryContains(String word, String[] dict){
//        for(int i = 0; i<dict.length; i++){
//            if(dict[i].replace(" ","").equals(word)){
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * Check whether a word is present in the dictionary or not
     * @param word  word
     * @param dict dictionary
     * @return map Map<Boolean, String>
     */
    private static Map<Boolean, String> getDictionaryContains(String word, String[] dict){
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
