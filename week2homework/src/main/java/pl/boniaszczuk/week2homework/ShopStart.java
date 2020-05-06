package pl.boniaszczuk.week2homework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopStart {
    private List<ShopItem> itemList;

    public ShopStart() {
        itemList = new ArrayList<>();
        itemList.add(new ShopItem("Kurtka", new BigDecimal(Math.floor(Math.random()*300+50))));
        itemList.add(new ShopItem("Plaszcz", new BigDecimal(Math.floor(Math.random()*300+50))));
        itemList.add(new ShopItem("Bluza", new BigDecimal(Math.floor(Math.random()*300+50))));
        itemList.add(new ShopItem("Spodnie", new BigDecimal(Math.floor(Math.random()*300+50))));
        itemList.add(new ShopItem("Czapka", new BigDecimal(Math.floor(Math.random()*300+50))));
        BigDecimal result = itemList.stream().map(ShopItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void getAllPrices() {
        BigDecimal result = itemList.stream().map(ShopItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
    }

    public List<ShopItem> getItemList() {
        return itemList;
    }
}
