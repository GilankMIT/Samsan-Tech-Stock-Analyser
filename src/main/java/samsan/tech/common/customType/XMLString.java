package samsan.tech.common.customType;

public class XMLString implements CustomType{
    public String value;

    public XMLString(){}

    public XMLString(String text){
        this.value = text;
    }

    public static XMLString fromString(String text){
        XMLString newXMLString = new XMLString();
        newXMLString.value = text;
        return newXMLString;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
