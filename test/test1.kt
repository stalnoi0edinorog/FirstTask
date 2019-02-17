

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class Tests {
    val book1 = OneAdress("Рокбелл" to Triple("Алхимическая", "18", "64"))
    val book2 = OneAdress("Петрунина" to Triple("Мстительная", "81", "55"))
    val book3 = OneAdress("Ананас" to Triple("Мстительная", "11", "98"))
    val book4 = OneAdress("Друг" to Triple("Мстительная", "11", "67"))

    @Test
    fun person(){
        assertEquals("Рокбелл", book1.person())
    }

    @Test
    fun adress(){
        assertEquals(Triple("Алхимическая", "18", "64"), book1.adress())
    }

    @Test
    fun adressOfPerson(){
        assertEquals(Triple("Алхимическая", "18", "64"),
            AdressBook(mutableListOf(book1, book2)).adressOfPerson("Рокбелл") )
        assertEquals(Triple("Мстительная", "11", "98"),
            AdressBook(mutableListOf(book1, book3)).adressOfPerson("Ананас") )
    }

    @Test
    fun sameStreet(){
        assertEquals(listOf("Петрунина","Ананас", "Друг"),
            AdressBook(mutableListOf(book1, book2, book3, book4)).sameStreet("Мстительная"))
    }

    @Test
    fun sameHouse(){
        assertEquals(listOf("Ананас", "Друг"),
            AdressBook(mutableListOf(book1, book2, book3, book4)).sameHouse("Мстительная" to "11"))
    }

    @Test // всё, что ниже не работает :/
    fun addPair(){
        val pair = "Ананас" to Triple("Мстительная", "11", "98")
        AdressBook(mutableListOf(book1, book2)).addPair(pair)
        assertEquals(AdressBook(mutableListOf(book1, book2, book3)), AdressBook(mutableListOf(book1, book2)))
    }

    @Test
    fun delete(){
        AdressBook(mutableListOf(book1, book2, book3, book4)).delete("Ананас")
        assertEquals(AdressBook(mutableListOf(book1, book2, book4)), AdressBook(mutableListOf(book1, book2, book3, book4)))
    }
}