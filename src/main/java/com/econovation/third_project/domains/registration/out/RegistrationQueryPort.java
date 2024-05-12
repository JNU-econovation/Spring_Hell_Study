package com.econovation.third_project.domains.registration.out;

import com.econovation.third_project.database.Registration;

import java.util.Collection;

public interface RegistrationQueryPort {
    Collection<Registration> findAllRegistration();
}
