package com.fortitudetec.elucidation;

import com.fortitudetec.elucidation.config.AppConfig;
import com.fortitudetec.elucidation.server.ElucidationBundle;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<AppConfig>() {

            @Override
            public PooledDataSourceFactory getDataSourceFactory(AppConfig configuration) {
                return configuration.getDataSourceFactory();
            }
        });

        bootstrap.addBundle(new ElucidationBundle<AppConfig>() {

            @Override
            public PooledDataSourceFactory getDataSourceFactory(AppConfig configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(AppConfig config, Environment env) {
        LOG.info("Starting Elucidation Server");
    }
}