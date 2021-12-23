/*
 * Copyright © 2021 Michal K. Owsiak. All rights reserved.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package recipeNo016.redux;

public class SigTerm {

  /* This is the native method we want to call */
  public static native void callExitCode();

  /* Inside static block we will load shared library */
  static {
    System.loadLibrary("SigTerm");
  }

  public static void main(String[] args) {
    /* 
      This message will help you determine whether
      java.library.path is correctly set
    */
    System.out.println("library: " + System.getProperty("java.library.path"));

    /* Call to shared library */
    try {
      // We are surrounding with try - catch.
      // JNI will throw exception when exit function is called.
      System.out.println("Calling riskyCode() with atexit based handler");
      SigTerm.callExitCode();
    } catch (Exception ex) {
      // We will end up here catching exception produced by JNI.
      System.out.println("Exception - application tried to call exit");
    }
  }
}
