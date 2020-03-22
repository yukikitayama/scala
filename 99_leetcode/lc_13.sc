// https://leetcode.com/problems/roman-to-integer/
// https://leetcode.com/problems/roman-to-integer/discuss/169471/Scala-solution-using-foldLeft
// https://leetcode.com/problems/roman-to-integer/discuss/244585/plain-scala

/*
def romanToInt(s: String): Int = {
  // Map, key -> value
  val hashmap = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
  s.map(hashmap)
}
*/

def romanToInt(s: String): Int = {
  val sReplaced = s.replace("IV", "IIII")
                   .replace("IX", "VIIII")
                   .replace("XL", "XXXX")
                   .replace("XC", "LXXXX")
                   .replace("CD", "CCCC")
                   .replace("CM", "DCCCC")

  sReplaced
}
