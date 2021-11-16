package com.geekbrains.frontend;

import com.geekbrains.entity.Person;
import com.geekbrains.service.PersonService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Route("add_user")
public class NewPersonForm extends VerticalLayout {
    TextField tfLogin = new TextField();
    PasswordField tfPassword = new PasswordField();
    TextField tfFirstName = new TextField();
    TextField tfMiddleName = new TextField();
    TextField tfSecondName = new TextField();
    TextField tfPhone = new TextField();
    TextArea taAddress = new TextArea();
    EmailField tfEmail = new EmailField();

    private final BCryptPasswordEncoder passwordEncoder;
    private final PersonService personService;

    @Autowired
    public NewPersonForm(BCryptPasswordEncoder passwordEncoder, PersonService personService) {
        this.passwordEncoder = passwordEncoder;
        this.personService = personService;
        initForm();
    }

    private void initForm() {
        this.setSizeFull();
        this.setAlignItems(Alignment.CENTER);
        this.setWidthFull();

        H1 lTitle = new H1();
        lTitle.setText("Регистрация нового пользователя");
        add(lTitle);

        tfLogin.setLabel("Логин");
        tfLogin.setWidth("30%");
        add(tfLogin);


        tfPassword.setLabel("Пароль");
        tfPassword.setWidth("30%");
        add(tfPassword);

        tfFirstName.setLabel("Имя");
        tfFirstName.setWidth("30%");
        add(tfFirstName);

        tfMiddleName.setLabel("Отчество");
        tfMiddleName.setWidth("30%");
        add(tfMiddleName);


        tfSecondName.setLabel("Фамилия");
        tfSecondName.setWidth("30%");
        add(tfSecondName);

        tfPhone = new TextField();
        tfPhone.setLabel("Телефон");
        tfPhone.setWidth("30%");
        add(tfPhone);

        taAddress.setLabel("Адрес");
        taAddress.setWidth("30%");
        add(taAddress);


        tfEmail.setLabel("Электронная почта");
        tfEmail.setPlaceholder("example@email.com");
        tfEmail.setErrorMessage("Адрес введен некорректно");
        tfEmail.setWidth("30%");
        add(tfEmail);


        Button btnSave = new Button("Сохранить", event -> {
            saveForm();
        });
        btnSave.setText("Сохранить");
        Button btnCancel = new Button("Сброс", event -> {
            resetFields();
        });
        add(new HorizontalLayout(btnSave, btnCancel));

    }

    private void resetFields() {
        tfLogin.setValue("");
        tfPassword.setValue("");
        tfFirstName.setValue("");
        tfSecondName.setValue("");
        tfMiddleName.setValue("");
        tfSecondName.setValue("");
        tfPhone.setValue("");
        taAddress.setValue("");
        tfEmail.setValue("");

    }

    private void saveForm() {
        Person person = new Person();

        if (personService.findPersonByLogin(tfLogin.getValue()) != null) {
            Notification.show("Ошибка при добавлении пользователя");
            tfLogin.setInvalid(true);
            tfLogin.setErrorMessage("Логин уже существует");
            return;
        }
        person.setFirstName(tfFirstName.getValue());
        person.setMiddleName(tfMiddleName.getValue());
        person.setLastName(tfSecondName.getValue());

        person.setPhone(tfPhone.getValue());
        person.setAddress(taAddress.getValue());
        person.setEmail(tfEmail.getValue());
        person.setLogin(tfLogin.getValue());
        person.setPassword(passwordEncoder.encode(tfPassword.getValue()));
        person.setRole("ROLE_USER");

        personService.savePerson(person);

        Notification.show("Пользователь добавлен");

    }


}
