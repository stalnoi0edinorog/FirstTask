
data class Address(var street: String, var house: String, var apart: String)

data class AddressBook(var addressList: MutableMap<String, Address>) {

    fun addressOfPerson(name: String): Address = addressList[name] ?: throw Exception()

    fun peopleOnTheSameStreet(street: String): List<String> {
            val list = mutableListOf<String>()
            for (address in addressList)
                if (street == address.value.street)
                    list.add(address.key)
            return list
        }

    fun peopleInTheSameHouse(house: Pair<String, String>): List<String>{
            val list = mutableListOf<String>()
            for (address in addressList)
                if (house.first == address.value.street && house.second == address.value.house)
                    list.add(address.key)
            return list
        }

    fun addPair(person: Pair<String, Address>) {
            val list = addressList.any { it.key == person.first }
            if (!list)
                addressList[person.first] = person.second

        }

    fun delete(human: String) = addressList.remove(human) //Удаляет ключ и возвращает адресс -> ???

    fun chahgeAddress(person: Pair<String, Address>) {
        delete(person.first)
        addPair(person)
    }
}









