package pl.boniaszczuk.week2homework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("Pro")
public class ShopPro {

    private ShopStart shopStart;

    @Autowired
    public ShopPro(ShopStart shopStart) {
        this.shopStart = shopStart;
    }

    @Value("${shop-info.vat}")
    private BigDecimal vat;
    @Value("${shop-info.discount}")
    private BigDecimal discount;

    @EventListener(ApplicationReadyEvent.class)
    public void addVatAndDiscount() {
        shopStart.getItemList().forEach(shopItem -> shopItem.setPrice(shopItem.getPrice()
                .multiply(vat).multiply(discount)));
    }


    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        System.out.println("Wybrales ShopPro");
    }
}
