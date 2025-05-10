import org.eclipse.lmos.arc.agents.dsl.extensions.MemoryScope

function(
    name = "get_travel_profile",
    description = "Returns reusable travel profile data for the user",
) {
    memory<String>("travel_profile") ?: "No travel profile found. Ask user for details."
}

function(
    name = "save_travel_profile_data",
    description = "Saves stable travel-related information provided by the user that can be used in future planning.",
    params = types(
        string("label", "A short label for the type of information (e.g., 'email', 'preferred_airline', 'hotel_in_bonn')"),
        string("value", "The corresponding value provided by the user")
    )
) { (label, value) ->

    val savedMemories = memory<String>("travel_profile") ?: ""
    val entry = "$label: $value"

    if (!savedMemories.contains(entry)) {
        val newMemories = if (savedMemories.isEmpty()) entry else "$entry, $savedMemories"
        memory("travel_profile", newMemories, MemoryScope.LONG_TERM)
        "Saved $label to user’s travel profile"
    } else {
        "This information is already in the travel profile. No changes made."
    }
}
