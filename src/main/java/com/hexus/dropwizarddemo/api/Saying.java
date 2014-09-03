package com.hexus.dropwizarddemo.api;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

@ApiModel("Saying")
public class Saying {
    @ApiModelProperty(value = "The id of the item", required = true)
    private long id;

    @Length(max = 3)
    @ApiModelProperty(value = "Content", required = true)
    private String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
