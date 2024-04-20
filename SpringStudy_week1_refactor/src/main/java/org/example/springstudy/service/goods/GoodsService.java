package org.example.springstudy.service.goods;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springstudy.domain.goods.Category;
import org.example.springstudy.domain.goods.CategoryRepository;
import org.example.springstudy.domain.goods.Goods;
import org.example.springstudy.domain.goods.GoodsRepository;
import org.example.springstudy.dto.goods.request.CreateCategoryDTO;
import org.example.springstudy.dto.goods.request.CreateGoodsDTO;
import org.example.springstudy.exception.CategoryNotFoundException;
import org.example.springstudy.exception.GoodsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final CategoryRepository categoryRepository;
    private final GoodsRepository goodsRepository;

    public Long createCategory(CreateCategoryDTO createCategoryDTO){
            Category category = Category.builder()
                    .name(createCategoryDTO.getName())
                    .build();
        return categoryRepository.save(category).getId();
    }
    @Transactional
    public Long createGoods(CreateGoodsDTO createGoodsDTO){
        Category category = findCategory(createGoodsDTO.getCategoryName());
        Goods goods = Goods.builder()
                .price(createGoodsDTO.getPrice())
                .stockQuantity(createGoodsDTO.getStockQuantity())
                .category(category)
                .build();
        return goodsRepository.save(goods).getId();
    }

    public List<Goods> findAllGoods(){
        return goodsRepository.findAll();
    }

    public Category findCategory(String categoryName){
        return categoryRepository.findByName(categoryName)
                .orElseThrow(CategoryNotFoundException::new);
    }

    public Goods findGoods(Long goodsId){
        return goodsRepository.findById(goodsId).orElseThrow(GoodsNotFoundException::new);
    }
}
