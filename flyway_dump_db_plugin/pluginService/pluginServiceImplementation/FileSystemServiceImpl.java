package com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceImplementation;

import com.journal.journal.modules.flyway_dump_db_plugin.pluginService.abstractions.AbstractProjectFileSystem;
import com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceInterface.FileSystemService;
import org.springframework.stereotype.Service;

@Service
public class FileSystemServiceImpl extends AbstractProjectFileSystem implements FileSystemService {

    @Override
    public final String getRootPackagePath() {
        FileSystemServiceImpl fileSystemService = new FileSystemServiceImpl();
        String[] result = fileSystemService
                .getClass()
                .getPackage()
                .getName()
                .split("\\.");
        return result[0].concat(this.PACKAGE_SEPARATOR).concat(result[1]);
    }
}
