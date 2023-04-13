package org.kiwiproject.elucidation;

import static org.assertj.core.api.Assertions.assertThat;

import org.kiwiproject.elucidation.config.AppConfig;
import org.kiwiproject.elucidation.server.resources.RelationshipResource;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@ExtendWith(DropwizardExtensionsSupport.class)
@DisplayName("App")
class AppTest {

    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("unit-config.yml");

    private static final DropwizardAppExtension<AppConfig> APP = new DropwizardAppExtension<>(
            App.class, CONFIG_PATH,
            ConfigOverride.config("database.url", "jdbc:sqlite::memory::")
    );

    @AfterAll
    static void removeDb() throws IOException {
        Files.deleteIfExists(Path.of("./:memory::"));
    }

    @Test
    void testRun() {
        assertThat(APP.getEnvironment().jersey().getResourceConfig().isRegistered(RelationshipResource.class)).isTrue();
    }

}