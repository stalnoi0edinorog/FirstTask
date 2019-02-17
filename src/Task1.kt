data class OneAdress(var inf: Pair<String, Triple<String, String, String>>){
    fun person() = inf.first

    fun adress() = inf.second
}

data class AdressBook(var listAdress: MutableList<OneAdress>) {

    fun adressOfPerson(name: String): Triple<String, String, String> {
            var result = Triple("", "", "")
            for (element in listAdress)
                if (name == element.person()) {
                    result = element.adress()
                    break
                }
            return result

        }

    fun sameStreet(street: String): List<String> {
            val list = mutableListOf<String>()
            for (element in listAdress)
                if (street == element.adress().first)
                    list.add(element.person())
            return list
        }

    fun sameHouse(house: Pair<String, String>): List<String>{
            val list = mutableListOf<String>()
            for (element in listAdress)
                if (house.first == element.adress().first && house.second == element.adress().second)
                    list.add(element.person())
            return list
        }

    fun addPair(human: Pair<String, Triple<String, String, String>>) {
            val list = listAdress.filter { it.inf.first == human.first }
            if (list.isEmpty())
                listAdress.add(OneAdress(human))
        }

    fun delete(human: String) = listAdress.filter { it.inf.first != human}

    fun chahgeAdress(): Nothing = TODO()




    }









