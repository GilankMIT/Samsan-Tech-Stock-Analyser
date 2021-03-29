package samsan.tech.common.adapter.jsonAdapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import samsan.tech.common.customType.JSONString;
import samsan.tech.common.customType.XMLString;
import samsan.tech.common.provider.XMLStockProvider;

import static org.junit.jupiter.api.Assertions.*;

class JsonAdapterTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void convertToJSONFromXML_correctXML_noException(){
        XMLString stockDataInXML = null;
        try {
            stockDataInXML = new XMLStockProvider().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonAdapter jsonAdapter = new JsonAdapter();
        JSONString convertedStockData = jsonAdapter.convertToJSONFromXML(stockDataInXML);
        new JSONObject(convertedStockData.getValue());
    }

    @Test
    public void convertToJSONFromXML_incorrectXML_throwException(){
        XMLString invalidXMLString = XMLString.fromString("<THIS IS AN INVALID XML");
        JsonAdapter jsonAdapter = new JsonAdapter();
        assertThrows(JSONException.class, () -> {
            jsonAdapter.convertToJSONFromXML(invalidXMLString);
        });
    }

    @Test
    public void printToJSON(){
        try {
            System.out.println(new JsonAdapter().convertToJSONFromXML(new XMLStockProvider().getData()).getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
