package org.example.MathFucnitions;

import org.example.exceptions.ZeroException;
import org.example.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuadraticEquation {
    private static final Logger logger = LoggerFactory.getLogger(QuadraticEquation.class);

    public MathematicsTypes toCalculate(Request request) throws NumberFormatException, NullPointerException {
        logger.info("Input {}", request.toString());
        double a = Double.parseDouble(request.getA());
        double b = Double.parseDouble(request.getB());
        double c = Double.parseDouble(request.getC());
        double d = b * b - 4 * a * c;
        logger.info("D ={}", d);
        if (d == 0) {
            double x1 = (b - Math.sqrt(d) / (a * 2));
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            SomeResult someResult = new SomeResult();
            someResult.setX1(x1);
            someResult.setX2(x2);
            logger.info("Result x1={}, x2={}", someResult.getX1(), someResult.getX2());
            return someResult;
        } else if (d > 0) {
            if (a == 0.0) {
                logger.info("You can’t divide into zero");
                throw new ZeroException();
            }
            double res = -b / (2 * a);
            SingleResult singleResult = new SingleResult();
            singleResult.setX(res);
            logger.info("Result x={}", singleResult.getX());
            return singleResult;
        } else {
            NullResult nullResult = new NullResult();
            logger.info("Result x={}", nullResult.getResult());
            return nullResult;
        }
    }
}
