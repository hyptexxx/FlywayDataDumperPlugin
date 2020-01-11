package com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceInterface;

public interface PluginService {
    boolean canRun();
    void run();
}
