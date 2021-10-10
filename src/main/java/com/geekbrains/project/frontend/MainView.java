package com.geekbrains.project.frontend;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainView extends VerticalLayout {
    public MainView(){

        HorizontalLayout titleLayout = new HorizontalLayout();
        HorizontalLayout buttonTextLayout = new HorizontalLayout();
        Text titleText = new Text("Интернет-магазин");
        Text buttonText = new Text("Здесь есть кнопка");

        Button button = new Button("Нажми меня",event ->  {
            Notification.show("Мы нажали кнопку");
        });
        titleLayout.add(titleText);
        buttonTextLayout.add(buttonText,button);
        add(titleLayout, buttonTextLayout);
    }
}
