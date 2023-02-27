package org.example.lombok;

import lombok.Cleanup;
import lombok.Value;
import lombok.val;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.util.logging.Logger;

@Log
public class ValueExample {

    public static void main(String[] args) {
        val as = "String";
        final String aa = "String";
        log.info("Hello Elshod");
    }


    @Value
    class MyImmutableClass {
        String field1;
        String field2;
        String field3;
    }

}
