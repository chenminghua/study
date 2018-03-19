package com.minghua.state;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Context {
    private State state;

    public Context(){
        this.state = null;
    }

}
