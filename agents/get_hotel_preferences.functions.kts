import org.eclipse.lmos.arc.agents.dsl.extensions.MemoryScope

function(
    name = "get_hotel_preferences",
    description = "Returns hotel preferences for a user",
) {
    memory<String>("hotel_preferences") ?: "Hotel preference not found, ask user to provide the details"
}

function(
    name = "save_user_hotel_preferences",
    description = "Returns hotel preferences for a user for a city.",
    params = types(
        string("city", "Name of the city"),
        string("hotel_preferences", "Hotel preferences of the user")
    )
) { (city, hotel_preferences) ->

    val savedMemories = memory<String>("hotel_preferences")
    var newMemories = "hotel_preferences for the city $city are: $hotel_preferences"

    if(savedMemories != null) {
        newMemories = newMemories + ", $savedMemories"
    }

    memory("hotel_preferences", newMemories, MemoryScope.LONG_TERM)
    "Saved hotel preferences for the city $city"
}