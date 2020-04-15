package com.demo.productservice.metrics;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.Arrays;

/**
 * <p>
 * Utility class used to register Metrics across the entire application.
 * Also contains any common Metric name Strings useful for developing
 * good metric naming convension within the application.
 * </p>
 */
public final class MetricsUtil {

  /** Singleton MetricRegistry instance to be used across entire application. */
  public static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();

  /* Private ctor for Utility Class. */
  private MetricsUtil() {}

  /**
   * Registers a metric Timer with the MetricRegistry.
   * @param names - 1 to * String names for the timer.
   * @return The registered Timer instance.
   */
  public static Timer registerTimer(final String... names) {
    return MetricsUtil.METRIC_REGISTRY.timer(
        MetricRegistry.name(concatenateNames(names)));
  }

  /**
   * Registers a metric Meter with the MetricRegistry.
   * @param names 1 to * String names for the meter.
   * @return The registered Meter instance.
   */
  public static Meter registerMeter(final String... names) {
    return MetricsUtil.METRIC_REGISTRY.meter(
        MetricRegistry.name(concatenateNames(names)));
  }

  /**
  * Registers a metric Gauge.
  * @param gauge Gauge of given type (int, long, String)
  * @param names 1 to * String names for the meter.
  * @return registered gauge instance
  */
  public static Gauge registerGauge(final Gauge<?> gauge, final String... names) {
    return MetricsUtil.METRIC_REGISTRY.register(concatenateNames(names), gauge);
  }

  private static String concatenateNames(final String... names) {
    return MetricRegistry.name(names[0], Arrays.copyOfRange(names, 1, names.length));
  }
}
