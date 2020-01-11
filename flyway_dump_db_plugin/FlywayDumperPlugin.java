package com.journal.journal.modules.flyway_dump_db_plugin;

import com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceInterface.PluginService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FlywayDumperPlugin {

    private final
    PluginService pluginService;

    public FlywayDumperPlugin(PluginService pluginService) {
        this.pluginService = pluginService;
    }

    @PostConstruct
    private void postConstruct() {
        if(pluginService.canRun()){
            pluginService.run();
        }
    }

}
