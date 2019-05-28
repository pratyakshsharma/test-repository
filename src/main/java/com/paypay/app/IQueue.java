package com.paypay.app;

import com.paypay.exception.CustomQueueException;

public interface IQueue<T> {

    public IQueue<T> enQueue(T t);
    //Removes the element at the beginning of the immutable queue, and returns the new queue.
    public IQueue<T> deQueue() throws CustomQueueException;
    public T head() throws CustomQueueException;
    public boolean isEmpty();
}
