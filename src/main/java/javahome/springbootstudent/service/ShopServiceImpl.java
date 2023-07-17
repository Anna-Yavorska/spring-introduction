package javahome.springbootstudent.service;


import javahome.springbootstudent.controller.dto.ShopDTO;
import javahome.springbootstudent.converter.ShopConverter;
import javahome.springbootstudent.exception.NotFoundException;
import javahome.springbootstudent.repository.ShopRepository;
import javahome.springbootstudent.repository.model.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ShopConverter shopConverter;

    public ShopServiceImpl(ShopRepository shopRepository, ShopConverter shopConverter) {
        this.shopRepository = shopRepository;
        this.shopConverter = shopConverter;
    }

    @Override
    public ShopDTO getShopById(Integer id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
        return shopConverter.convertToDTO(shop);
    }

    @Override
    public Collection<ShopDTO> getAllShops() {
        return shopConverter.convertToDTO(shopRepository.findAll());
    }

    @Override
    public Integer createShop(ShopDTO shopToCreate) {
        Shop shop = shopConverter.convertToEntity(shopToCreate);
        Shop savedShop = shopRepository.save(shop);
        return savedShop.getId();
    }
}
