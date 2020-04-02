package pojo.enums;
/**
 * workBreak枚举类型
 * @author Jo
 * @date 2020/04/01
 */
public enum WorkBreakTypeEnum {
    /**
     * 固定字典
     */
    FIXED_DICTIONARY(0,"固定字典"),
    /**
     * 用户自定义字典
     */
    USER_DICTIONARY(1, "用户自定义字典"),
    /**
     * 合成字典
     */
    BOTH(2, "合成字典")
    ;

    private Integer value;
    private String desc;


    WorkBreakTypeEnum(Integer value, String desc) {
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
