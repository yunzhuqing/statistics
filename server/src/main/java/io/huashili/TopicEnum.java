package io.huashili;

/**
 * topic 枚举
 */
public enum TopicEnum {
    INDEX("index", "index"),

    LOGIN("login", "login"),

    USER_TOTAL("user-total", "用户总数"),

    USER_TOTAL_HOUR("user-total-hour", "用户每小时总数");

    private String id;

    private String desc;

    TopicEnum(String id, String desc) {
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

    public String getId() {
        return id;
    }

    public static TopicEnum [] topics () {
        return values();
    }


}
