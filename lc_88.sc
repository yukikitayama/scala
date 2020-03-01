val nums1: Array[Int] = Array(1, 2, 3, 0, 0, 0)
val nums2: Array[Int] = Array(2, 5, 6)
val m: Int = 3
val n: Int = 3
// Output: [1, 2, 2, 3, 5, 6]

object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {

    // indices to extract elements from arrays
    var i = m - 1
    var j = n - 1

    // index to insert elements for ordered format
    var k = m + n - 1

    while (i >= 0 && j >= 0) {

      // from bigger elements
      if (nums1(i) >= nums2(j)) {

        // insert to the end of nums1
        nums1(k) = nums1(i)

        // update indices
        k -= 1
        i -= 1

        // debug
        // println(k, i, j)

      } else {
        nums1(k) = nums2(j)
        k -= 1
        j -= 1

        // debug
        // println(k, i, j)

      }
    }

    // debug
    println(k, i, j)

    // final elements insertion
    while (i >= 0) {
      nums1(k) = nums1(i)
      k -= 1
      i -= 1
    }

    // debug
    println(k, i, j)

    while (j >= 0) {
      nums1(k) = nums2(j)
      k -= 1
      j -= 1
    }

  }

  // debug
  // mkString converts array to string element by element
  println(nums1.mkString(" "))

}

// debug
Solution.merge(nums1, m, nums2, n)
