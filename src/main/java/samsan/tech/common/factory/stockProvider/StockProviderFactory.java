package samsan.tech.common.factory.stockProvider;

import samsan.tech.common.provider.JSONStockProvider;
import samsan.tech.common.provider.XMLStockProvider;

public class StockProviderFactory {

    public enum sourceFormat{
        JSON,
        XML
    }

    public StockProvider getStockProvider(sourceFormat stockProviderSourceFormat){
        if(stockProviderSourceFormat == sourceFormat.JSON){
            return new JSONStockProvider();
        }

        if(stockProviderSourceFormat == sourceFormat.XML){
            return new XMLStockProvider();
        }

        return null;
    }
}
