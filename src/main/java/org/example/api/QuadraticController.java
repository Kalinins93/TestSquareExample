package org.example.api;

import org.example.exceptions.MySQLException;
import org.example.exceptions.ZeroException;
import org.example.MathFucnitions.QuadraticEquation;
import org.example.services.ServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class QuadraticController {
    @Autowired
    QuadraticEquation quadraticEquation;
    @Autowired
    ServiceDB serviceDB;

    @GetMapping("/get")
    public ResponseEntity<?> toCalculate(@RequestParam Map<String, String> allParams) {
        try {
            serviceDB.save(allParams);
            return ResponseEntity.ok().body(quadraticEquation.toCalculate(allParams));
        } catch (NumberFormatException | ZeroException | SQLException exception) {
            if (exception instanceof NumberFormatException) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
            } else if (exception instanceof ZeroException) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
            } else {
                return ResponseEntity.status(500).body(exception.getMessage());
            }
        }
    }
}
