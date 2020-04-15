package com.demo.productservice.mapper;

import com.demo.productservice.common.ResponseStatus;
import com.demo.productservice.exceptions.ApplicationErrorType;
import com.demo.productservice.exceptions.BaseException;
import com.demo.productservice.request.BaseRequest;
import com.demo.productservice.response.BaseResponse;

/**
 * Mapper from FailureResponseMapper failure from an exception.
 */
public class FailureResponseMapper<T> extends AbstractMapper<Exception, T> {
  /**
   * Initialize the FailureResponseMapper.
   */
  protected FailureResponseMapper( T baseResponse) {
    super(baseResponse);
  }

  /**
   * Maps the Exception details into Response.
   *
   * @param <R>       The Request Type
   * @param exception The exception object thrown.
   * @param request   The Request object derived from BaseRequest.
   * @return mapped response with error information.
   */
  public <R extends BaseRequest> T map(final Exception exception, final R request) {
    super.map(exception);
    if(getDestination() instanceof BaseResponse) {
      final BaseResponse br = (BaseResponse) getDestination();
      br.setStatus(ResponseStatus.FAILURE.value());

      br.setError(exception.getMessage());
      if (exception instanceof BaseException) {
        final BaseException pbe = (BaseException) exception;
        br.setErrorCode(pbe.getErrorCode());
        br.setErrorType(pbe.getErrorCode());
      } else {
        br.setErrorCode(ApplicationErrorType.INTERNAL_SERVER_ERROR.value());
        br.setErrorType(ApplicationErrorType.INTERNAL_SERVER_ERROR.value());
      }
    }
    return getDestination();
  }
}
