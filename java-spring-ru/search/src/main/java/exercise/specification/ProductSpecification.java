package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO params) {
        return withCategory(params.getCategoryId())
                .and(withPriceGt(params.getPriceGt()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withRating(params.getRatingGt()))
                .and(withTitle(params.getTitleCont()));
    }

    public Specification<Product> withCategory(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction() :
                cb.equal(root.get("category").get("id"), categoryId);
    }

    public Specification<Product> withPriceGt(Integer price) {
        return (root, query, cb) -> price == null ? cb.conjunction() :
                cb.greaterThan(root.get("price"), price);
    }

    public Specification<Product> withPriceLt(Integer price) {
        return (root, query, cb) -> price == null ? cb.conjunction() :
                cb.lessThan(root.get("price"), price);
    }

    public Specification<Product> withRating(Double rating) {
        return (root, query, cb) -> rating == null ? cb.conjunction() :
                cb.greaterThan(root.get("rating"), rating);
    }

    public Specification<Product> withTitle(String title) {
        return (root, query, cb) -> title == null || title.isEmpty() ? cb.conjunction() :
                cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }
}
// END
