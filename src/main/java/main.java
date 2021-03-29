import samsan.tech.common.factory.stockProvider.StockProviderFactory;
import samsan.tech.data.repositories.JSONStockRepository;

public class main {
    public static void main(String[] args){
        //Scenario : We only have XML File available in the file system

        JSONStockRepository jsonStockRepository = new JSONStockRepository();
        System.out.println(jsonStockRepository.getStockNow());
    }
}
