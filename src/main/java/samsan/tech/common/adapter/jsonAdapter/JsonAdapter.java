package samsan.tech.common.adapter.jsonAdapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import samsan.tech.common.customType.JSONString;
import samsan.tech.common.customType.XMLString;

public class JsonAdapter {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public JSONString convertToJSONFromXML(XMLString xmlString) throws JSONException{
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString.getValue());
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            return new JSONString(jsonPrettyPrintString);
        } catch (JSONException je) {
            throw je;
        }
    }
}
