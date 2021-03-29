package samsan.tech.application.stock;

import samsan.tech.data.repositories.JSONStockRepository;
import samsan.tech.entity.Stock;

public class StockUseCase {
    private JSONStockRepository stockRepository= new JSONStockRepository();
    public Stock getStockNow(){
        return stockRepository.getStockNow();
    }
}
