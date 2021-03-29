package samsan.tech.common.customType;

public class JSONString implements CustomType{
    private String value;

    public JSONString(){}

    public JSONString(String text){
        this.value = text;
    }

    public static JSONString fromString(String text){
        JSONString newJSONString = new JSONString();
        newJSONString.value = text;
        return newJSONString;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
