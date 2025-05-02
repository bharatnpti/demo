

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
    name = "list_hotels",
    description = "List available hotels.",
) {
    """
     Name: The King's Hotel
     Price: 100 euros
     Location: Berlin
     
     Name: The Prince Hotel
     Price: 80 euros
     Location: Bonn
     
     Name: The Queen Hotel
     Price: 200 euros
     Location: Hamburg
  """
}


function(
    name = "get_weather",
    description = "Returns the current weather.",
    params = types(
        string("location", "the location to get the weather for."),
    )
) { (location) ->
    """The weather is sunny in $location. A lovely 32 degrees celsius."""
}
