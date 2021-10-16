package com.geekbrains.project.frontend;

import com.geekbrains.project.entity.Product;
import com.geekbrains.project.service.ProductService;
import com.vaadin.flow.component.Text;
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

@Route("main")
public class MainView extends VerticalLayout {
    private final Grid<Product> productGrid = new Grid<>(Product.class);

    private final ProductService productService;

    public MainView(ProductService productService) {
        this.productService = productService;

        initPage();
    }

    private void initPage() {
        var cartLayout = initCartButton();
        initProductGrid();

        add(productGrid, cartLayout);
    }

    private HorizontalLayout initCartButton() {
        var addToCardButton = new Button("Добавить в корзину", event -> {
            //TODO: Сохранение в бд какому-либо пользователю
            Notification.show("Товар успешно добавлен в корзину");
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
