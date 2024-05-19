package com.econovation.third_project.domains.registration.adaptor;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domains.registration.out.RegistrationQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class RegistrationAdaptor implements RegistrationQueryPort {
    private final Database database;

    @Override
    public Collection<Registration> findAllRegistration() {
        return database.findAllRegistration();
    }
}
