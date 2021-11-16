package com.geekbrains.frontend;

import com.geekbrains.component.CurrentPerson;
import com.geekbrains.entity.Cart;
import com.geekbrains.entity.Product;
import com.geekbrains.service.CartService;
import com.geekbrains.service.ProductService;
import com.geekbrains.service.PersonService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.concurrent.CopyOnWriteArrayList;

@Route("main")
public class MainView extends VerticalLayout {
    private final Grid<Product> productGrid = new Grid<>(Product.class);

    private final ProductService productService;
    private final PersonService personService;
    private final CartService cartService;
    private final CurrentPerson currentPerson;

    @Autowired
    public MainView(ProductService productService, PersonService personService, CartService cartService, CurrentPerson currentPerson) {
        this.productService = productService;
        this.personService = personService;
        this.cartService = cartService;
        this.currentPerson = currentPerson;
        initPage();
    }

    private void initPage() {
        var cartLayout = initCartButton();
        initProductGrid();

        add(productGrid, cartLayout);

        currentPerson.setPerson(personService.findPersonByName("Name-0"));
        System.out.println(currentPerson.getPerson());
    }

    private HorizontalLayout initCartButton() {
        var addToCardButton = new Button("Добавить в корзину", event -> {
            Cart cart = new Cart();
            cart.setUser(currentPerson.getPerson());

            cart.setProducts(new CopyOnWriteArrayList<>());
            for (Product item : productGrid.getSelectedItems()) {
                var cartProduct = new Cart.InnerProduct();
                cartProduct.setName(item.getName());
                cartProduct.setCount(item.getCount());
                cartProduct.setId(item.getId());
                cartProduct.setPrice(item.getPrice());
                cartProduct.setVendorCode(item.getVendorCode());
                cart.getProducts().add(cartProduct);
            }
            cartService.saveCart(cart);
            Notification.show("Товары успешно добавлен в корзину");
        });

        var toCartButton = new Button("Корзина", event -> {
            UI.getCurrent().navigate("cart");
        });

        return new HorizontalLayout(addToCardButton, toCartButton);
    }

    private void initProductGrid() {
        var products = productService.getAll();

        productGrid.setItems(products);
        productGrid.setColumns("name", "price", "count", "vendorCode");
        productGrid.setSizeUndefined();
        productGrid.setSelectionMode(Grid.SelectionMode.MULTI);

        ListDataProvider<Product> dataProvider = DataProvider.ofCollection(products);
        productGrid.setDataProvider(dataProvider);

        productGrid.addColumn(new ComponentRenderer<>(item -> {
            var plusButton = new Button("+", i -> {
                item.incrementCount();
                productService.save(item);
                productGrid.getDataProvider().refreshItem(item);
            });

            var minusButton = new Button("-", i -> {
                item.decreaseCount();
                productService.save(item);
                productGrid.getDataProvider().refreshItem(item);
            });

            return new HorizontalLayout(plusButton, minusButton);
        }));
    }
}

