package pl.boniaszczuk.week2homework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Plus")
public class ShopPlus {

    private ShopStart shopStart;

    @Autowired
    public ShopPlus(ShopStart shopStart) {
        this.shopStart = shopStart;
    }

    @Value("${shop-info.vat}")
    private double vat;

    @EventListener(ApplicationReadyEvent.class)
    public void addVat(){
        shopStart.getItemList().forEach(shopItem -> shopItem.setPrice(shopItem.getPrice()*vat));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        System.out.println("Wybrales ShopPlus");
    }




}
