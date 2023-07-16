package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.ShopDTO;
import javahome.springbootstudent.repository.model.Shop;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ShopConverter {

    public Shop convertToEntity(ShopDTO source) {
        Shop result = new Shop();
        result.setName(source.getName());
        result.setAddressId(source.getAddressId());
        return result;
    }

    public ShopDTO convertToDTO(Shop shop) {
        return convertShopToDto(shop);
    }

    public List<ShopDTO> convertToDTO(Collection<Shop> shops) {
        return shops.stream()
                .map(this::convertShopToDto)
                .toList();
    }

    private ShopDTO convertShopToDto(Shop source) {
        ShopDTO result = new ShopDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setAddressId(source.getAddressId());
        result.setPhone(source.getPhone());
        return result;
    }
}
