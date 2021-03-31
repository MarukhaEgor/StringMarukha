/**
 * A class that represents a string, basic string functions.
 */
class StringMarukha {

    private val chars: CharArray

    constructor(str: String) {
        chars = CharArray(str.length)
        for (i in str.indices)
            chars[i] = str[i]
    }

    constructor(c: CharArray) {
        chars = CharArray(c.size)
        for (i in c.indices)
            chars[i] = c[i]
    }

    constructor(ch: Char) {
        chars = CharArray(1)
        chars[0] = ch
    }

    /**
     * parse some string to float
     */
    fun toFloat(): Float{
        return parseToFloat(this)
    }

    /**
     * parse some string to float
     */
    fun parseToFloat(str: StringMarukha): Float {
        //container for left part of float
        var tempFloat: Float
        //container for right part of float
        var tempFloatD = 0.0f
        var isNegative = false
        var endIndex = 0
        if (chars[0] == '-') {
            isNegative = true
            endIndex = 1
        }
        var j = 10f
        var startPoint = str.indexOf('.') - 1
        tempFloat = (chars[startPoint] - 48).toFloat()
        startPoint -= 1
        // cycle for getting left part of float number
        for (i in startPoint downTo endIndex) {
            tempFloat += (chars[i] - 48).toInt() * j
            j *= 10f
        }
        j = 1f
        startPoint = str.indexOf('.') + 1
        // cycle for getting right part of float number
        for (i in chars.size - 1 downTo startPoint) {
            tempFloatD += (chars[i] - 48).toInt() * j
            j *= 10f
        }
        tempFloatD /= j
        if (isNegative) {
            return -1 * (tempFloat + tempFloatD)
        }
        return tempFloat + tempFloatD
    }

    /**
     * Get substring from some string
     */
    fun subString(startIndex: Int, endIndex: Int): StringMarukha {
        if (startIndex < 0 || startIndex > endIndex || endIndex > chars.size) {
            throw StringIndexOutOfBoundsException(
                    "begin $startIndex, end $endIndex, length $chars.size"
            )
        }
        val temp = CharArray(endIndex - startIndex)
        System.arraycopy(chars, startIndex, temp, 0, endIndex - startIndex)
        return StringMarukha(temp)
    }

    /**
     * Convert integer number to string
     */
    fun intToString(number: Int): StringMarukha {
        var tempNumber = number
        var tempStr = StringMarukha("")
        if (number == 0) return StringMarukha("0")
        if (number < 0) {
            tempNumber = -tempNumber
        }
        while (tempNumber > 0) {
            tempStr = tempStr.concat((tempNumber % 10 + 48).toChar())
            tempNumber /= 10
        }
        if (number < 0) {
            tempStr = tempStr.concat(StringMarukha("-"))
        }
        return tempStr.reversed()
    }

    /**
     * Adding some string to string
     */
    fun concat(newStr: StringMarukha): StringMarukha {
        var newerStrLength: Int = newStr.length()
        newerStrLength += chars.size
        val temp = CharArray(newerStrLength)
        System.arraycopy(chars, 0, temp, 0, chars.size)
        System.arraycopy(newStr.chars, 0, temp, chars.size, newStr.chars.size)
        return StringMarukha(temp)
    }

    /**
     * Adding some char to string
     */
    fun concat(char: Char): StringMarukha {
        return concat(StringMarukha(char.toString()))
    }

    /**
     * Override fun that convert custom string to String
     */
    override fun toString(): String {
        var toStr = ""
        for (element in chars) {
            toStr = toStr + element + ""
        }
        return toStr
    }

    /**
     * Check does the string contain the character
     */
    fun contains(char: Char): Boolean {
        return indexOf(char) >= 0
    }

    /**
     * Return length of string
     */
    fun length(): Int {
        return chars.size
    }

    /**
     * finds the first index of occurrence of an element
     */
    fun indexOf(char: Char): Int {
        for (i in chars.indices) {
            if (chars[i] == char) {
                return i
            }
        }
        return -1
    }

    /**
     * finds the first index of occurrence of an element from end
     */
    fun lastIndexOf(char: Char): Int {
        for (i in chars.size - 1 downTo 0) {
            if (chars[i] == char) {
                return i
            }
        }
        return -1
    }

    /**
     * Returns the reverse of the string
     */
    fun reversed(): StringMarukha {
        var tempStr = StringMarukha("")
        for (i in this.chars.size - 1 downTo 0) {
            tempStr = tempStr.concat(chars[i])
        }
        return tempStr
    }
}
