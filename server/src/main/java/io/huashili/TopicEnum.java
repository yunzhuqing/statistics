package io.huashili;

/**
 * topic 枚举
 */
public enum TopicEnum {
    LOGIN("login", "login");

    private String id;

    private String desc;

    private TopicEnum(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static boolean contains(String id) {
        TopicEnum [] topics = values();
        for(TopicEnum topic : topics) {
            if(topic.desc.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
