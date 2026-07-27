class TimeMap() {

    val key_value_list = mutableMapOf<String, ArrayList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val list = key_value_list.getOrDefault(key, mutableListOf())
        list.add(Pair(timestamp, value))

        key_value_list[key] = ArrayList<Pair<Int, String>>(list)
    }

    fun get(key: String, timestamp: Int): String {
        val list = key_value_list.getOrDefault(key, emptyList())

        var st = 0
        var end = list.size - 1

        var value = ""

        while(st <= end){
            val mid = st + (end - st)/2

            if(list[mid].first <= timestamp){
                value = list[mid].second
            }

            if(timestamp < list[mid].first){
                end = mid-1
            }else{
                st = mid+1
            }
        }

        return value

    }
}
