package org.training.user.service.config;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyCloakManager {

    private final KeyCloakProperties keyCloakProperties;

    /**
     * Returns the KeyCloak instance for the specified realm.
     *
     * @return  the KeyCloak instance for the specified realm
     */
    public RealmResource getKeyCloakInstanceWithRealm() {

        return keyCloakProperties.getKeycloakInstance().realm(keyCloakProperties.getRealm());
    }
}
