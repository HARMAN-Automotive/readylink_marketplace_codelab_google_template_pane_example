package com.harman.ready.link.marketplace.codelab.template.google.pane;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.car.app.CarAppService;
import androidx.car.app.Session;
import androidx.car.app.Screen;
import androidx.car.app.validation.HostValidator;
import android.content.Intent;

public class MyCarAppService extends CarAppService {

    @NonNull
    @Override
    public HostValidator createHostValidator() {
        // Allow all hosts (for development).
        // In production, you might want to restrict to known host certificates.
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR;
    }

    @NonNull
    @Override
    public Session onCreateSession() {
        // Return a new Session for each new host (car display) connection.
        return new Session() {
            @Override
            @NonNull
            public Screen onCreateScreen(@Nullable Intent intent) {
                // This is where we set the first Screen in our app.
                return new MyScreen(getCarContext());
            }
        };
    }
}
