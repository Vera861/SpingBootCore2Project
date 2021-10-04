package com.geekbrains.project.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MainView extends VerticalLayout {
    public MainView(){
        Button button = new Button("Press me",event ->  {
            Notification.show("We pressed the button");
        });
        add(button);
    }
}
