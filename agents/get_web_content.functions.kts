// 
//
// SPDX-License-Identifier: Apache-2.0

function(
    name = "get_web_content",
    description = "Returns content from the web.",
    params = types(
        string("url", "The URL of the content to fetch.")
    )
) { (url) ->
    if (url.toString().endsWith(".pdf")) {
        pdf(url.toString()).getOrThrow()
    } else {
        html(url.toString()).getOrThrow()
    }

}