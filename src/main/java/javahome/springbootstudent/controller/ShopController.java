package javahome.springbootstudent.controller;

import javahome.springbootstudent.controller.dto.ShopDTO;

import javahome.springbootstudent.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/{id}")
    public ShopDTO getById(@PathVariable Integer id) {
        return shopService.getShopById(id);
    }

    @GetMapping
    public Collection<ShopDTO> getAllShops() {
        return shopService.getAllShops();
    }

    @PostMapping
    public Integer createShop(@RequestBody ShopDTO shopDTO) {
        return shopService.createShop(shopDTO);
    }
}
