package com.demo.productservice.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractHandler exposes methods to validate requests, response and handle the process.
 * T - {@link request}
 * S - {@link response}
 */
public abstract class AbstractHandler<T, S> implements IHandler<T, S> {
  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractHandler.class);
  /**
   * Handler method.
   * @param request request.
   * @return response.
   */
  @Override
  public S handle(final T request) {
    try {
      validateRequest(request);
      return process(request);
    } catch (Exception ex) {
      LOGGER.error("Exception Occured while processing product: "+ex.getStackTrace().toString());
      return handleException(ex, request);
    }
  }

  /**
   * Performs any necessary request validation.
   *
   * @param request The incoming request from the clients
   */
  protected abstract void validateRequest(final T request);

  /**
   * Process the request and returns the response.
   *
   * @param request The validated request
   * @return The response object
   * @throws Exception Exception.
   */
  protected abstract S process(final T request) throws Exception;

  /**
   * Handles exceptions and build response with failures.
   *
   * @param exception Exception thrown by downstream clients
   * @return response with failures
   */
  protected abstract S handleException(
      final Exception exception,
      final T changeItineraryRequest);
}
