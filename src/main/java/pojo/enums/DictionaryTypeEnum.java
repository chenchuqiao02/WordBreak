package pojo.enums;
/**
 * workBreakTypeEnum
 * @author Jo
 * @date 2020/04/01
 */
public enum WordBreakTypeEnum {
    /**
     * the fixed dictionary
     */
    FIXED_DICTIONARY(0,"固定字典"),
    /**
     * the user customized dictionary
     */
    USER_DICTIONARY(1, "用户自定义字典"),
    /**
     *  both dictionaries
     */
    BOTH(2, "合成字典")
    ;

    private Integer value;
    private String desc;


    WordBreakTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
