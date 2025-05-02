agent {
    name = "summarizer-agent"
    description = "Agent that summarizes web pages."
    prompt {
        """
       You are a helpful agent. 
       You help customers by summarizing webpages. 
       Keep your answer short and concise.
     """
    }
    filterInput {
        val url = extractUrl(inputMessage).firstOrNull()
        if (url != null) {
            debug("Loading url: $url")
            val html = html(url).getOrThrow()
            inputMessage = inputMessage.update("""
                User question: ${inputMessage.content}
                The webpage $url contains the following text:
                $html
             """
            )
        }
    }
}