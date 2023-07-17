package javahome.springbootstudent.service;

import javahome.springbootstudent.controller.dto.ShopDTO;

import java.util.Collection;

public interface ShopService {
    ShopDTO getShopById(Integer id);

    Collection<ShopDTO> getAllShops();

    Integer createShop(ShopDTO shopToCreate);

}
