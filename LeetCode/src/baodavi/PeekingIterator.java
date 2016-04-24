package baodavi;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iterator = null;
	private Integer tmp = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iterator = iterator;
	    if(this.iterator.hasNext())
	    	this.tmp = this.iterator.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return this.tmp;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int hehe = this.tmp;
	    if(this.iterator.hasNext()){
	    	this.tmp = this.iterator.next();
	    }else{
	    	this.tmp = null;
	    }
	    
	    return hehe;
	}

	@Override
	public boolean hasNext() {
	    return this.tmp == null;
	}
}



///**
// * Implementation of PeekingIterator that avoids peeking unless necessary.
// */
//private static class PeekingImpl<E> implements PeekingIterator<E> {
//
//  private final Iterator<? extends E> iterator;
//  private boolean hasPeeked;
//  private E peekedElement;
//
//  public PeekingImpl(Iterator<? extends E> iterator) {
//    this.iterator = checkNotNull(iterator);
//  }
//
//  @Override
//  public boolean hasNext() {
//    return hasPeeked || iterator.hasNext();
//  }
//
//  @Override
//  public E next() {
//    if (!hasPeeked) {
//      return iterator.next();
//    }
//    E result = peekedElement;
//    hasPeeked = false;
//    peekedElement = null;
//    return result;
//  }
//
//  @Override
//  public void remove() {
//    checkState(!hasPeeked, "Can't remove after you've peeked at next");
//    iterator.remove();
//  }
//
//  @Override
//  public E peek() {
//    if (!hasPeeked) {
//      peekedElement = iterator.next();
//      hasPeeked = true;
//    }
//    return peekedElement;
//  }
//}



