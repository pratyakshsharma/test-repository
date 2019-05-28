package com.paypay.app;

import com.paypay.exception.CustomQueueException;

/**
 * This class is the concrete class that represents an Immutable Queue.
 * <p>
 * This uses two stacks <b>stackForDequeuing</b> and <b>stackForEnqueuing</b> to keep track of the elements.
 * The <b>stackForEnqueuing</b> stack keeps track of the elements being enQueued (since a queue is like a reverse stack).
 * The <b>stackForDequeuing</b> stack keeps track of the elements being deQueued.
 * The operations enQueue(), head() and isEmpty() runs in constant, i.e.,O(1) time.
 * The deQueue() operation runs in O(n) time in worst case and O(1) time in best case. The worst case O(n)
 * time arises since that could involve reversing of the full <b>stackForDequeuing</b> stack.
 * </p>
 *
 * @param <T> generic type for the elements of the queue
 */
public class ImmutableQueue<T> implements IQueue<T> {

    private final IStack<T> stackForEnqueuing;
    private final IStack<T> stackForDequeuing;

    private ImmutableQueue(IStack<T> stackForDequeuing, IStack<T> stackForEnqueuing)
    {
        this.stackForDequeuing = stackForDequeuing;
        this.stackForEnqueuing = stackForEnqueuing;
    }

    /**
     * Reverses the provided stack.
     * @param stack
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final static IStack reverseStack(IStack stack) throws CustomQueueException
    {
        IStack r = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty()){
            r = r.push(stack.head());
            stack = stack.pop();
        }

        return r;
    }

    @SuppressWarnings({ "rawtypes" })
    public final static IQueue getEmptyQueue(){
        return EmptyImmutableQueue.getInstance();
    }

    public final IQueue<T> enQueue(T t){
        return new ImmutableQueue<T>(stackForDequeuing, stackForEnqueuing.push(t));
    }

    @SuppressWarnings("unchecked")
    public final IQueue<T> deQueue() throws CustomQueueException{
        IStack<T> f = stackForDequeuing.pop();
        if (!f.isEmpty()){
            return new ImmutableQueue<T>(f, stackForEnqueuing);
        }
        else if (stackForEnqueuing.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(stackForEnqueuing), ImmutableStack.getEmptyStack());
        }
    }

    public final T head() throws CustomQueueException {
        return stackForDequeuing.head();
    }

    public final boolean isEmpty(){
        return false;
    }

    /**
     * Represents an empty queue. This is a singleton.
     * @author asifiqbal
     *
     * @param <T>
     */
    private static final class EmptyImmutableQueue<T> implements IQueue<T>{

        @SuppressWarnings("rawtypes")
        private final static EmptyImmutableQueue emptyImmutableQueue = new EmptyImmutableQueue();

        @SuppressWarnings("rawtypes")
        public final static EmptyImmutableQueue getInstance(){
            return emptyImmutableQueue;
        }

        @SuppressWarnings("unchecked")
        public final IQueue<T> enQueue(T t){
            return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
        }

        public final IQueue<T> deQueue() throws CustomQueueException{
            throw new CustomQueueException("Queue is empty.");
        }

        public final T head() throws CustomQueueException{
            throw new CustomQueueException("Queue is empty.");
        }

        public final boolean isEmpty(){
            return true;
        }
    }
}
