# JavaPractice

#Priority Queue project contains
Application build process must be based on maven. Application must contain two modules
named core and util.

util module must contain priority queue class implemented using binary max heap
stored in array. Please find details here: http://en.wikipedia.org/wiki/Binary_heap.

Priority queue must be thread safe, but please do not use "synchronized" keyword.
core module must contain printer class. Printer must use priority queue and must have
the following interface:
public interface Printer {
<T extends Comparable<T>> String asSortedString(T... values);
}

For example invoking printer.asSortedString(1,4,6,3,2) will return string "6,4,3,2,1".

All classes must be written in TDD way and tests must include all border cases. Priority
queue must have proper unit tests. Printer must have proper unit tests (tested in isolation) 
and integration tests (tested together with priority queue). While testing Printer
in isolation please mock priority queue.
