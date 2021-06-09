package com.ning.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {


        log.info("insertFill");
        this.strictInsertFill(metaObject, "datetime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updatetime", LocalDateTime.class, LocalDateTime.now());

        if (this.getFieldValByName("age", metaObject) == null)
            this.strictInsertFill(metaObject, "age", Integer.class, 3);
        if (metaObject.hasSetter("author"))
            this.strictInsertFill(metaObject, "author", String.class, "hell");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill");
        this.strictUpdateFill(metaObject, "updatetime", LocalDateTime.class, LocalDateTime.now());
    }
}
