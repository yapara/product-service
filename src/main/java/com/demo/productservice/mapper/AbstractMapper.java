package com.demo.productservice.mapper;

/**
 * AbstractMapper.
 * @param <S> Source.
 * @param <D> Destination.
 */
public abstract class AbstractMapper<S, D> {
  private final D destination;
  private S source;

  /**
   * AbstractMapper constructor.
   * @param destination Destination.
   */
  protected AbstractMapper(final D destination) {
    this.destination = destination;
  }

  /**
   * Gets Source.
   * @return Source.
   */
  public S getSource() {
    return this.source;
  }

  /**
   * Sets Source.
   * @param source Source.
   */
  public void setSource(final S source) {
    this.source = source;
  }

  public D getDestination() {
    return this.destination;
  }

  /**
   *  validate the source and the destination.
   *  if it is null, throw exception
   */
  public void validate() {
    if (this.source == null) {
      throw new IllegalArgumentException("Source value(s) are required");
    }

    if (this.destination == null) {
      throw new IllegalArgumentException("Destination value is required");
    }
  }

  /**
   * Implement this method to mark a class as a Mapper that produces a
   * mapped type S object of type D.
   *
   * @param source source object to map from.
   */
  public D map(final S source) {
    setSource(source);
    validate();
    return getDestination();
  }
}
