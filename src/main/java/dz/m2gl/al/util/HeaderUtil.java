package dz.m2gl.al.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * Created by amine on 1/5/17.
 */
public class HeaderUtil {

    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

    public static HttpHeaders createAlert(String message, String param, String jwt) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-jtwtestapp-alert", message);
        headers.add("X-jtwtestApp-params", param);
        headers.add("x-token", jwt);
        return headers;
    }

    public static HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-jtwtestapp-alert", message);
        headers.add("X-jtwtestApp-params", param);
        return headers;
    }
    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
        return createAlert("A new " + entityName + " is created with identifier " + param, param);
    }

    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return createAlert("A " + entityName + " is updated with identifier " + param, param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return createAlert("A " + entityName + " is deleted with identifier " + param, param);
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        log.error("Entity creation failed, {}", defaultMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-jtwtestapp-alert", defaultMessage);
        headers.add("X-jtwtestApp-params", entityName);
        return headers;
    }
    public static HttpHeaders validationFailureAlert(String entityName, String field, String code) {
        log.error("Entity creation failed, {}, {}", field,code);
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-field", field);
        headers.add("X-code", code);
        return headers;
    }


    public static HttpHeaders errorType(String type, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-type", type);
        headers.add("X-message", message);
        return headers;
    }
}
