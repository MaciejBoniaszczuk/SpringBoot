package pl.boniaszczuk.week2homework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopStart {
    private List<ShopItem> itemList;

    public ShopStart() {
        ShopItem item1 = new ShopItem("Kurtka",Math.floor(Math.random()*300+50));
        ShopItem item2 = new ShopItem("Plaszcz",Math.floor(Math.random()*300+50));
        ShopItem item3 = new ShopItem("Bluza",Math.floor(Math.random()*300+50));
        ShopItem item4 = new ShopItem("Spodnie",Math.floor(Math.random()*300+50));
        ShopItem item5 = new ShopItem("Czapka",Math.floor(Math.random()*300+50));
        itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void getAllPrices(){
        double sum = itemList.stream().mapToDouble(ShopItem::getPrice).sum();
        System.out.println(sum);
    }

    public List<ShopItem> getItemList(){
        return itemList;
    }
}
