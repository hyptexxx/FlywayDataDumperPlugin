package com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceImplementation;

import com.journal.journal.modules.flyway_dump_db_plugin.enums.RunEnumerationTypes;
import com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceInterface.FileSystemService;
import com.journal.journal.modules.flyway_dump_db_plugin.pluginService.pluginServiceInterface.PluginService;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.journal.journal.modules.flyway_dump_db_plugin.annotations.FlywayDataDumper;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class PluginServiceImpl implements PluginService {

    private final
    FileSystemService fileSystemService;

    public PluginServiceImpl(FileSystemService fileSystemService) {
        this.fileSystemService = fileSystemService;
    }

    @Override
    public boolean canRun() {
        switch (getValueOfAnnotation()) {
            case PRODUCTION: return false;
            case DEVELOPMENT: return true;
        }
        return true;
    }

    @Override
    public void run() {

    }

    private RunEnumerationTypes getValueOfAnnotation() {
        Object value = null;
        Reflections ref = new Reflections(fileSystemService.getRootPackagePath());
        for (Class<?> cl : ref.getTypesAnnotatedWith(FlywayDataDumper.class)) {
            FlywayDataDumper findable = cl.getAnnotation(FlywayDataDumper.class);
            Class<? extends Annotation> type = findable.annotationType();
            for (Method method : type.getDeclaredMethods()) {
                try {
                    value = method.invoke(findable, (Object[]) null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return (RunEnumerationTypes) value;
    }
}
