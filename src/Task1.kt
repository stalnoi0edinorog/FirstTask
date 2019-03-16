
data class Address(val street: String, val house: String, val apart: String)

data class AddressBook(val addressMap: MutableMap<String, Address>) {

    fun addressOfPerson(name: String): Address? = addressMap[name]

    fun sameStreet(street: String): List<String> {
            val list = mutableListOf<String>()
            for ((person, address) in addressMap)
                if (street == address.street)
                    list.add(person)
            return list
        }

    fun sameHouse(house: Address): List<String>{
            val list = mutableListOf<String>()
            for ((person, address) in addressMap)
                if (house.street == address.street && house.house == address.house)
                    list.add(person)
            return list
        }

    fun addPersonAddress(person: String, address: Address) {
        val hasSamePerson = person in addressMap
        if (!hasSamePerson)
                addressMap[person] = address
        }

    fun delete(human: String) = addressMap.remove(human)

    fun changeAddress(person: String, address: Address) {
        delete(person)
        addPersonAddress(person, address)
    }
}









