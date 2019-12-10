package cn.kelibra.demo.multilanguage;


public class LanguageBean {
    private String realName;
    private String localeName;

    public LanguageBean(String realName, String localeName) {
        this.realName = realName;
        this.localeName = localeName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String localeName) {
        this.localeName = localeName;
    }
}
