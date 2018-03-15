package com.minghua.abstractFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
@Getter
public enum HumanEnum {
    YelloMaleHuman("com.minghua.abstractFactory.YelloMaleHuman"),
    WhiteFemmaleHuman("com.minghua.abstractFactory.WhiteFemaleHuman");

    private String value;

    HumanEnum(String value) {
        this.value = value;
    }


}
