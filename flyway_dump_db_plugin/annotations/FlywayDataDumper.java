package com.journal.journal.modules.flyway_dump_db_plugin.annotations;

import com.journal.journal.modules.flyway_dump_db_plugin.enums.RunEnumerationTypes;

import java.lang.annotation.*;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FlywayDataDumper {
    RunEnumerationTypes RunType() default RunEnumerationTypes.DEVELOPMENT;
}


