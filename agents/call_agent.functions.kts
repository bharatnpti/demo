#!/usr/bin/env kotlin
import org.eclipse.lmos.arc.agents.conversation.Conversation
import org.eclipse.lmos.arc.agents.conversation.UserMessage
import org.eclipse.lmos.arc.agents.conversation.AssistantMessage
import org.eclipse.lmos.arc.agents.conversation.latest

function(
    name = "call_agent",
    description = "Calls another agent.",
    params = types(
        string("name", "the name of the agent to call."),
        string("question", "the question to aks the agent.")
    )
) { (agentName, question) ->

    emitMessage("Calling $agentName with '$question'...")
    memory("last_call_agent", agentName)

    // we get the current conversation and replace the last message with the new question to ask the agent.
    val conversation = get<Conversation>().removeLast() + UserMessage(question.toString())
    val resultConversation = callAgent(agentName.toString(), conversation).getOrNull()
    resultConversation?.latest<AssistantMessage>()?.content ?: "I couldn't reach the agent."
}