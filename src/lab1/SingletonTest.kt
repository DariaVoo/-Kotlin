package lab1

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SingletonTest {
    @Test
    @Tag("Singleton")
    fun testSingleton() {
        val first = Singleton.instance
        first.b = "Hi!"
        println(first)
        assertEquals(expected ="Hi!", actual = first.b)

        val second = Singleton.instance
        println(second)
        assertEquals(expected ="Hi!", actual = second.b)
    }

    @Test
    fun getB() {

    }

    @Test
    fun setB() {
    }
}
