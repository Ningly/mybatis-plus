package com.ning.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "t_user")
public class User {
//    @TableId(type = IdType.ASSIGN_UUID)
    @TableId(value = "uid")
    private Long id;
    private String name;
    @TableField(value = "age",fill = FieldFill.INSERT)
    private Integer age;
    private String email;
    @TableField(value = "date_time",fill = FieldFill.INSERT)
    private LocalDateTime datetime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatetime;

    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;
}
