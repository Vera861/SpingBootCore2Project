package com.geekbrains.project.frontend;

import com.geekbrains.project.component.CurrentPerson;
import com.geekbrains.project.entity.Cart;
import com.geekbrains.project.service.CartService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cart")
public class CartView extends VerticalLayout {

    private final Grid<Cart.InnerProduct> cartProductGrid = new Grid<>(Cart.InnerProduct.class);
    private Cart cart;

    private final CurrentPerson currentPerson;
    private final CartService cartService;

    @Autowired
    public CartView(CurrentPerson currentPerson, CartService cartService) {
        this.currentPerson = currentPerson;
        this.cartService = cartService;
        init();
    }

    private void init() {
        System.out.println(currentPerson.getUser());
        this.cart = cartService.getCart(currentPerson.getUser());
        initCartGrid();
        add(cartProductGrid);
    }

    private void initCartGrid() {

        cartProductGrid.setItems(cart.getProducts());
        cartProductGrid.setColumns("name", "price", "count", "vendorCode");
        cartProductGrid.setSizeUndefined();

    }
}
