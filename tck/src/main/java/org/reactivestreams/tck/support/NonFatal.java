package org.reactivestreams.tck.support;


/**
 * Copy of scala.control.util.NonFatal in order to not depend on scala-library
 */
public class NonFatal {
  /**
   * Returns true if the provided `Throwable` is to be considered non-fatal, or false if it is to be considered fatal
   */
  public static boolean apply(Throwable t) {
    if (t instanceof StackOverflowError) {
      // StackOverflowError ok even though it is a VirtualMachineError
      return true;
    } else if (t instanceof VirtualMachineError ||
        t instanceof ThreadDeath ||
        t instanceof InterruptedException ||
        t instanceof LinkageError) {
      // VirtualMachineError includes OutOfMemoryError and other fatal errors
      return false;
    } else {
      return true;
    }
  }
}
