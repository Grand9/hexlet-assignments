package exercise.mapper;

import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

// BEGIN
@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Component
public interface ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    Product toEntity(ProductCreateDTO dto);

    @Mapping(target = "title", source = "name")
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "vendorCode", source = "barcode")
    ProductDTO toDto(Product model);

    List<ProductDTO> toDtoList(List<Product> products);

    @Mapping(target = "cost", source = "price")
    void update(ProductUpdateDTO dto, @MappingTarget Product model);
}

// END
