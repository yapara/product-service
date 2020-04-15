package com.demo.productservice.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility.
 */
public final class JsonUtility {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtility.class);
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private JsonUtility() {
  }

  /**
   * Convert object to JSON string.
   * @param obj Object
   * @return String.
   */
  public static String objectToJson(
      final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(obj);
    } catch (final Exception e) {
      LOGGER.warn("JSON serialization exception: "+e.getStackTrace().toString());
      return null;
    }
  }
}
