package io.huashili;

/**
 * 聚合类型
 */
public enum GroupType {
    HOUR, DAY, MONTH;

    public static GroupType valueOf(int id) {
        GroupType [] vals = values();
        for(GroupType groupType : vals) {
            if(groupType.ordinal() == id) {
                return groupType;
            }
        }
        return HOUR;
    }
}
