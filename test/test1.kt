import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class Tests {
    val address1 = Address("Алхимическая", "18", "64")
    val address2 =  Address("Мстительная", "81", "55")
    val address3 =  Address("Мстительная", "11", "98")
    val address4 =  Address("Мстительная", "11", "67")

    val addressBook = mutableMapOf(
        "Петрунина" to address1,
        "Ананас" to address2,
        "Солонко" to address3,
        "Яо" to address4)


    @Test
    fun addressOfPerson(){
        assertEquals(Address("Алхимическая", "18", "64"),
            AddressBook(addressBook).addressOfPerson("Петрунина"))

        assertEquals(Address("Мстительная", "81", "55"),
            AddressBook(addressBook).addressOfPerson("Ананас") )
    }

    @Test
    fun peopleOnTheSameStreet(){
        assertEquals(listOf("Ананас","Солонко", "Яо"), AddressBook(addressBook).peopleOnTheSameStreet("Мстительная"))
        assertEquals(listOf("Петрунина"), AddressBook(addressBook).peopleOnTheSameStreet("Алхимическая"))
    }

    @Test
    fun peopleInTheSameHouse(){
        assertEquals(listOf("Солонко", "Яо"), AddressBook(addressBook).peopleInTheSameHouse("Мстительная" to "11"))
        assertEquals(listOf("Ананас"), AddressBook(addressBook).peopleInTheSameHouse("Мстительная" to "81"))
    }

    @Test
    fun addPair(){
        val addressB1 = AddressBook(mutableMapOf("Ананас" to address2, "Солонко" to address3, "Яо" to address4))
        addressB1.addPair("Петрунина" to address1)
        assertEquals(AddressBook(addressBook), addressB1)

        val addressB2 = AddressBook(mutableMapOf("Петрунина" to address1, "Ананас" to address2, "Яо" to address4))
        addressB2.addPair("Солонко" to address3)
        assertEquals(AddressBook(addressBook), addressB2)

        val addressB3 = AddressBook(mutableMapOf("Петрунина" to address1, "Ананас" to address2, "Солонко" to address3))
        addressB3.addPair("Яо" to address4)
        assertEquals(AddressBook(addressBook), addressB3)
    }

    @Test
    fun delete() {
        val addressB1 = AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
        addressB1.delete("Ананас")
        assertEquals(
            AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Солонко" to address3,
                "Яо" to address4)),
            addressB1)

        val addressB2 = AddressBook(
            mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
        addressB2.delete("Солонко")
        assertEquals(
            AddressBook(mutableMapOf("Петрунина" to address1,
                "Ананас" to address2,
                "Яо" to address4)),
            addressB2)

        val addressB3 = AddressBook(
            mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
        addressB3.delete("Яо")
        assertEquals(
            AddressBook(mutableMapOf("Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3)),
            addressB3
        )
    }

        @Test
        fun chahgeAddress(){
            val addressBB1 = AddressBook(mutableMapOf( // ** От addressBook работает неправильно -> ???
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
            addressBB1.chahgeAddress( "Яо" to Address("Смольная", "21", "876"))
            assertEquals(AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to Address("Смольная", "21", "876"))), addressBB1)

            val addressBB2 = AddressBook(mutableMapOf( // **
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
            addressBB2.chahgeAddress( "Солонко" to Address("Карасаева", "58", "14"))
            assertEquals(AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Яо" to address4,
                "Солонко" to Address("Карасаева", "58", "14"))), addressBB2)

        }

    }