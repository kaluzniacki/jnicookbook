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

#include <stdio.h>
#include <stdlib.h>
#include "jni.h"
#include "recipeNoD003_redux_AllocateMemory.h"

JNIEXPORT jboolean JNICALL Java_recipeNoD003_redux_AllocateMemory_allocate
  (JNIEnv * env, jclass obj, jint size) {

  printf("Allocating memory: %u\n", size);

  char *ptr = malloc( size );
  
  if(ptr == NULL) {
    return JNI_FALSE;
  }

  return JNI_TRUE;
  
}
