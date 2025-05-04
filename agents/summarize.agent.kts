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
    tools {
        +"get_web_content"
    }
}