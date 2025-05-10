function(
    name = "book_hotel",
    description = "Books a hotel.",
    params = types(
        string("name", "The name of the hotel to book.")
    )
) { (hotel) ->
    """
      $hotel was booked successfully.
  """
}

function(
    name = "get_weather",
    description = "Returns the current weather.",
    params = types(
        string("location", "the location to get the weather for."),
    )
) { (location) ->
    when (location) {
        "Bonn" -> "The weather is sunny in Bonn. A lovely 20 degrees Celsius."
        "Berlin" -> "The weather is partly cloudy in Berlin. A mild 17 degrees Celsius."
        "Hamburg" -> "The weather is breezy in Hamburg. A comfortable 18 degrees Celsius."
        else -> "Weather data for $location is currently unavailable."
    }
}

data class Hotel(
    val name: String,
    val price: String,
    val rating: Double,
    val location: String,
    val highlights: String,
    val transit: String,
    val whyBook: String
)





function(
    name = "list_hotels",
    description = "List available hotels for a given city, with details including price, rating, highlights, transit proximity, and reasons to book.",
    params = types(
        string("location", "The name of the city to search hotels in")
    )
) { location ->
    val city = location.firstOrNull() ?: "Unknown"

    val hotels = listOf(
        Hotel(
            name = "The King's Hotel",
            price = "100 euros",
            rating = 8.7,
            location = "Berlin",
            highlights = "Located in Mitte district, near Museum Island and Brandenburg Gate",
            transit = "3-minute walk to Friedrichstraße U-Bahn station",
            whyBook = "Ideal for first-time visitors, close to cultural landmarks and public transport."
        ),
        Hotel(
            name = "Urban Nest Berlin",
            price = "120 euros",
            rating = 9.1,
            location = "Berlin",
            highlights = "Trendy Kreuzberg area, close to cafes and nightlife",
            transit = "2-minute walk to Görlitzer Bahnhof",
            whyBook = "Perfect for young travelers looking to experience Berlin’s local culture."
        ),
        Hotel(
            name = "The Prince Hotel",
            price = "80 euros",
            rating = 8.3,
            location = "Bonn",
            highlights = "Overlooks the Rhine River, near historic Altstadt",
            transit = "5-minute tram to Bonn Hauptbahnhof",
            whyBook = "Scenic river walks and historic charm, great for couples or relaxed stays."
        ),
        Hotel(
            name = "Rheinblick Suites",
            price = "95 euros",
            rating = 9.0,
            location = "Bonn",
            highlights = "Direct river view, next to Beethoven's House",
            transit = "8-minute walk to main tram lines",
            whyBook = "Comfort with a view, ideal for culture and calm."
        ),
        Hotel(
            name = "The Queen Hotel",
            price = "200 euros",
            rating = 9.2,
            location = "Hamburg",
            highlights = "Located in HafenCity with harbor views",
            transit = "7-minute walk to Baumwall U-Bahn station",
            whyBook = "Modern luxury near waterfront and cultural venues."
        ),
        Hotel(
            name = "Alster View Hotel",
            price = "140 euros",
            rating = 8.8,
            location = "Hamburg",
            highlights = "View of Außenalster Lake, serene atmosphere",
            transit = "5-minute walk to Uhlenhorst bus stop",
            whyBook = "Perfect for peaceful stays near nature within city limits."
        )
    )


    val results = hotels.filter { it.location.trim().equals(city.toString(), ignoreCase = true) }

    if (results.isEmpty()) {
        "No hotels found in $location."
    } else {
        results.joinToString("\n\n") { hotel ->
            """
            Name: ${hotel.name}
            Price: ${hotel.price}
            Rating: ${hotel.rating} / 10
            Highlights: ${hotel.highlights}
            Transit: ${hotel.transit}
            Why book: ${hotel.whyBook}
            """.trimIndent()
        }
    }
}
