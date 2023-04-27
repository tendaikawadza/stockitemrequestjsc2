package StockItemRequest.StockItemRequestJSC.nofication;

import StockItemRequest.StockItemRequestJSC.model.StockItemRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockItemRequestProducer {

    private StockItemRequest stockItemRequest;

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public StockItemRequestProducer(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStockItemRequestCreatedMessage(StockItemRequest stockItemRequest) {
        rabbitTemplate.convertAndSend("stock-item-request-exchange", "stock-item-request.created", stockItemRequest);
    }
}