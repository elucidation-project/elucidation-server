package org.kiwiproject.elucidation.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kiwiproject.elucidation.server.config.ElucidationConfiguration;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class AppConfig extends Configuration implements ElucidationConfiguration<AppConfig> {

    @Valid
    @JsonProperty("database")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

}
