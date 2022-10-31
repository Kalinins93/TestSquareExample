package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public final class NullResult implements MathematicsTypes {
    private  final String result = new String("This expression hasn't  equation roots");
}
