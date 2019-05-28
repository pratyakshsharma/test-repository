package com.paypay.app;

import com.paypay.exception.CustomStackException;

public class ImmutableStack<T> implements IStack<T> {

    private final T head;
    private final IStack<T> tail;

    private ImmutableStack(T head, IStack<T> tail){
        this.head = head;
        this.tail = tail;
    }

    public final IStack<T> push(T t){
        return new ImmutableStack<T>(t, this);
    }

    public final IStack<T> pop(){
        return tail;
    }

    public final T head(){
        return head;
    }

    public final boolean isEmpty(){
        return false;
    }

    @SuppressWarnings("rawtypes")
    public final static IStack getEmptyStack(){
        return EmptyImmutableStack.getInstance();
    }

    /**
     * Represents an empty stack. This is a singleton.
     * @author asifiqbal
     *
     * @param <T>
     */
    private static final class EmptyImmutableStack<T> implements IStack<T>{

        @SuppressWarnings("rawtypes")
        private final static EmptyImmutableStack emptyImmutableStack = new EmptyImmutableStack();

        @SuppressWarnings("rawtypes")
        public final static EmptyImmutableStack getInstance(){
            return emptyImmutableStack;
        }

        public final IStack<T> push(T t){
            return new ImmutableStack<T>(t, this);
        }

        public final IStack<T> pop() throws CustomStackException{
            throw new CustomStackException("Stack is empty.");
        }

        public final T head() throws CustomStackException{
            throw new CustomStackException("Stack is empty.");
        }

        public final boolean isEmpty(){
            return true;
        }
    }
}
