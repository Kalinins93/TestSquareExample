package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Request {
    private String a;
    private String b;
    private String c;

    @Override
    public String toString() {
        return "Request-> {" +"a='" + a +", b='" + b + ", c='" + c + '}';
    }
}
