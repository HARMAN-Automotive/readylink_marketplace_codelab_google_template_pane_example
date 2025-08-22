package com.harman.ready.link.marketplace.codelab.template.google.pane;

import androidx.annotation.NonNull;
import androidx.car.app.Screen;
import androidx.car.app.CarContext;
import androidx.car.app.model.Pane;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;
import androidx.car.app.model.Action;
import androidx.car.app.model.PaneTemplate;
import androidx.car.app.model.ActionStrip;
import androidx.car.app.CarToast;

public class MyScreen extends Screen {

    public MyScreen(@NonNull CarContext carContext) {
        super(carContext);
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        // 1. Create content rows
        Row helloRow = new Row.Builder()
                .setTitle("Hello, Android Automotive!")
                .build();

        Pane pane = new Pane.Builder()
                .addRow(helloRow)
                .build();

        // 2. (Optional) Add a button action
        Action sayHiAction = new Action.Builder()
                .setTitle("Say Hi")
                .setOnClickListener(() -> {
                    // Show a toast in the car UI
                    CarToast.makeText(getCarContext(),"Hello from the car!",CarToast.LENGTH_SHORT).show();
                })
                .build();

        ActionStrip actionStrip = new ActionStrip.Builder()
                .addAction(sayHiAction)
                .build();

        // 3. Build the template with the pane and action
        return new PaneTemplate.Builder(pane)
                .setHeaderAction(Action.APP_ICON)    // Show app icon in header.
                .setActionStrip(actionStrip)         // Add our action button.
                .build();
    }
}