package StockItemRequest.StockItemRequestJSC.model;

import StockItemRequest.StockItemRequestJSC.nofication.StockItemRequestProducer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;


@Data
@Entity
public class StockItemRequest {
    @Autowired
    private StockItemRequestProducer producer;

    @PostPersist
    public void onStockItemRequestCreated() {
        producer.sendStockItemRequestCreatedMessage(this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    private String requestingDepartment;
    private Integer productCode;
    private String departmentCode;
    private String purposeOfIssue;
    private String  itemDescription;
    private Date dateOfPreviousIssue;
    private Integer  previusIssueQuatinty;
    private  Integer estimatedValue;

    private Integer quantity;



}
