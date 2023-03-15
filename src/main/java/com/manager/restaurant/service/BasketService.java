package com.manager.restaurant.service;

import com.manager.restaurant.dto.request.BasketItemRequest;
import com.manager.restaurant.dto.response.EmptyBasketResponse;
import com.manager.restaurant.exception.BasketNotPresentException;
import com.manager.restaurant.model.basket.Basket;
import com.manager.restaurant.model.menu.MenuItem;
import com.manager.restaurant.model.basket.BasketItem;
import com.manager.restaurant.repository.basket.BasketItemRepository;
import com.manager.restaurant.repository.basket.BasketRepository;
import com.manager.restaurant.repository.menu.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final MenuItemRepository menuItemRepository;
    private final BasketItemRepository basketItemRepository;
    public EmptyBasketResponse getEmptyBasket() {
        Basket basket = Basket.builder().build();
        basketRepository.save(basket);

        return EmptyBasketResponse.builder().basketId(basket.getId()).build();
    }

    public Basket addOrDeleteItemFromBasket(String basketId, BasketItemRequest basketItemRequest) {
        Basket basket = basketRepository.findById(Long.valueOf(basketId))
                .orElseThrow(() -> new BasketNotPresentException("No Basket is present with given id."));
        Long menuItemId = basketItemRequest.getItemId();

        List<BasketItem> basketItems = basket.getBasketItems();
        List<BasketItem> basketItemsFilteredList = basketItems.stream()
                .filter(basketItem -> basketItem.getMenuItem().getId().equals(menuItemId))
                .toList();
        BasketItem basketItem;
        if (basketItemsFilteredList.isEmpty()) {
            MenuItem menuItemInRequest = menuItemRepository.findById(menuItemId)
                    .orElseThrow(() -> new BasketNotPresentException("Invalid menuItemId passed"));

            basketItem = BasketItem.builder()
                .menuItem(menuItemInRequest)
                .quantity(basketItemRequest.getQuantity())
                .basketItemTotal(menuItemInRequest.getPrice() * basketItemRequest.getQuantity())
                .build();

            basketItems.add(basketItem);
        } else {
            basketItem = basketItemsFilteredList.get(0);
            basketItem.setQuantity(basketItemRequest.getQuantity());
            basketItem.setBasketItemTotal(basketItem.getMenuItem().getPrice() * basketItemRequest.getQuantity());
        }
        basketItemRepository.save(basketItem);

        double totalPrice = 0.0;
        for (BasketItem basketItem1: basketItems) {
            totalPrice += basketItem1.getBasketItemTotal();
        }
        basket.setBasketItems(basketItems);
        basket.setTotalPrice(totalPrice);

        basketRepository.save(basket);
        return basket;
    }
}
