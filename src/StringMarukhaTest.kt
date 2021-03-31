import org.junit.jupiter.api.Assertions.*

internal class StringMarukhaTest {

    private lateinit var str: String
    private lateinit var reStr: StringMarukha

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        reStr = StringMarukha("12345.9432122")
        str = "12345.9432122"
    }

    @org.junit.jupiter.api.Test
    fun parseToFloat() {
        assertEquals(reStr.parseToFloat(reStr), str.toFloat())
    }

    @org.junit.jupiter.api.Test
    fun toFloat() {
        assertEquals(reStr.toFloat(), str.toFloat())
    }

    @org.junit.jupiter.api.Test
    fun subString() {
        assertEquals(reStr.subString(2, 5).toString(), str.substring(2, 5))
    }

    @org.junit.jupiter.api.Test
    fun intToString() {
        val testStr = 12345
        assertEquals(reStr.intToString(testStr).toString(), testStr.toString())
    }

    @org.junit.jupiter.api.Test
    fun concat() {
        assertEquals(reStr.concat(StringMarukha("123")).toString(), str + "123")
    }

    @org.junit.jupiter.api.Test
    fun testConcat() {
        assertEquals(reStr.concat('1').toString(), str + '1')
    }

    @org.junit.jupiter.api.Test
    fun contains() {
        assertEquals(reStr.contains('1'), str.contains('1'))
    }

    @org.junit.jupiter.api.Test
    fun length() {
        assertEquals(reStr.length(), str.length)
    }

    @org.junit.jupiter.api.Test
    fun indexOf() {
        assertEquals(reStr.indexOf('1'), str.indexOf('1'))
    }


    @org.junit.jupiter.api.Test
    fun lastIndexOf() {
        assertEquals(reStr.lastIndexOf('1'), str.lastIndexOf('1'))
    }

    @org.junit.jupiter.api.Test
    fun reversed() {
        assertEquals(reStr.reversed().toString(), str.reversed())
    }
}