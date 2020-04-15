package com.demo.productservice.handlers;

/**
 * Interface for different handlers like product Handler.
 * @param <T> request type.
 * @param <S> response type.
 */
public interface IHandler<T, S> {
  /**
   * Handle method.
   * @param request Request.
   * @return Response.
   * @throws Exception Exception.
   */
  S handle(final T request) throws Exception;
}
