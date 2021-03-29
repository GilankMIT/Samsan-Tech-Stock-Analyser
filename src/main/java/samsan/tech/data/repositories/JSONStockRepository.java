package samsan.tech.data.repositories;
import com.google.gson.Gson;
import samsan.tech.common.adapter.jsonAdapter.JsonAdapter;
import samsan.tech.common.customType.JSONString;
import samsan.tech.common.customType.XMLString;
import samsan.tech.common.dto.Stock.JSONStockProviderDTO;
import samsan.tech.common.provider.JSONStockProvider;
import samsan.tech.common.provider.XMLStockProvider;
import samsan.tech.data.repositoryInterface.IStockRepository;
import samsan.tech.entity.Stock;
import samsan.tech.common.factory.stockProvider.StockProviderFactory;

public class JSONStockRepository implements IStockRepository {
    //Scenario : We only have XML File available in the file system
    JSONStockProvider jsonStockProvider = (JSONStockProvider) new StockProviderFactory().getStockProvider(StockProviderFactory.sourceFormat.JSON);
    XMLStockProvider xmlStockProvider = (XMLStockProvider) new StockProviderFactory().getStockProvider(StockProviderFactory.sourceFormat.XML);
    @Override
    public Stock getStockNow(){
        JSONString stockDataInJSON = new JSONString("");

        boolean successToGetJSON = false;
        try {
            stockDataInJSON = jsonStockProvider.getData();
            successToGetJSON = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sadly we failed to retrieve data in JSON, try other provider instead
        if(!successToGetJSON){
            try {
                XMLString stockDataInXML = xmlStockProvider.getData();

                //introduce adapter here
                JsonAdapter jsonAdapter = new JsonAdapter();
                stockDataInJSON = jsonAdapter.convertToJSONFromXML(stockDataInXML);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return parseStockFromJSON(stockDataInJSON);
    }

    private Stock parseStockFromJSON(JSONString jsonString){
        JSONStockProviderDTO dto;
        Gson gson = new Gson();
        dto = gson.fromJson(jsonString.getValue(), JSONStockProviderDTO.class);
        System.out.println(dto.root.row.get(1).Date);
        return null;
    }
}
