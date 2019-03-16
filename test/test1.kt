import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class Tests {
    private val address1 =  Address("Алхимическая", "18", "64")
    private val address2 =  Address("Мстительная", "81", "55")
    private val address3 =  Address("Мстительная", "11", "98")
    private val address4 =  Address("Мстительная", "11", "67")

    private val addressBook = mutableMapOf(
        "Петрунина" to address1,
        "Ананас" to address2,
        "Солонко" to address3,
        "Яо" to address4)


    @Test
    fun addressOfPerson(){
        assertEquals(address1,
            AddressBook(addressBook).addressOfPerson("Петрунина"))
        assertEquals(null,
            AddressBook(addressBook).addressOfPerson(""))
        assertEquals(null,
            AddressBook(addressBook).addressOfPerson("Лермонтов"))
        assertEquals(address2,
            AddressBook(addressBook).addressOfPerson("Ананас") )
    }

    @Test
    fun sameStreet(){
        assertEquals(listOf("Ананас","Солонко", "Яо"), AddressBook(addressBook).sameStreet("Мстительная"))
        assertEquals(listOf("Петрунина"), AddressBook(addressBook).sameStreet("Алхимическая"))
        assertEquals(listOf(), AddressBook(addressBook).sameStreet("Тулина"))
        assertEquals(listOf(), AddressBook(addressBook).sameStreet(""))
    }

    @Test
    fun sameHouse(){
        assertEquals(listOf("Солонко", "Яо"), AddressBook(addressBook).sameHouse(Address("Мстительная", "11", "56")))
        assertEquals(listOf("Ананас"), AddressBook(addressBook).sameHouse(Address("Мстительная", "81", "54")))
        assertEquals(listOf(), AddressBook(addressBook).sameHouse(Address("Мстительная", "2", "14")))

    }

    @Test
    fun addPersonAddress(){
        val addressB1 = AddressBook(mutableMapOf("Ананас" to address2, "Солонко" to address3, "Яо" to address4))
        addressB1.addPersonAddress("Петрунина", address1)
        assertEquals(AddressBook(addressBook), addressB1)

        val addressB2 = AddressBook(mutableMapOf("Петрунина" to address1, "Ананас" to address2, "Яо" to address4))
        addressB2.addPersonAddress("Солонко", address3)
        assertEquals(AddressBook(addressBook), addressB2)

        val addressB3 = AddressBook(mutableMapOf("Петрунина" to address1, "Ананас" to address2, "Солонко" to address3))
        addressB3.addPersonAddress("Яо", address4)
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
        fun changeAddress(){
            val addressBB1 = AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
            addressBB1.changeAddress( "Яо", Address("Смольная", "21", "876"))
            assertEquals(AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to Address("Смольная", "21", "876"))), addressBB1)

            val addressBB2 = AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Солонко" to address3,
                "Яо" to address4))
            addressBB2.changeAddress( "Солонко", Address("Карасаева", "58", "14"))
            assertEquals(AddressBook(mutableMapOf(
                "Петрунина" to address1,
                "Ананас" to address2,
                "Яо" to address4,
                "Солонко" to Address("Карасаева", "58", "14"))), addressBB2)

        }

    }