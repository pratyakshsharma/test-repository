package com.paypay.app;

import com.paypay.exception.CustomStackException;

public interface IStack<T> {

    /**
     *
     * @param t generic type for the elements of the stack
     * @return the new stack after inserting the element {@code t} to the end of the stack
     */
    public IStack<T> push(T t);

    /**
     *
     * @return the new stack after removing the element from the end of the stack
     */
    public IStack<T> pop() throws CustomStackException;

    /**
     *
     * @return the head (end) element of the stack
     * @throws CustomStackException when queue is empty
     */
    public T head() throws CustomStackException;

    /**
     *
     * @return true when stack is empty, false otherwise
     */
    public boolean isEmpty();
}
