package com.paulnsorensen.burnerphone

import com.twilio.twiml.Dial
import com.twilio.twiml.Number
import com.twilio.twiml.Say
import com.twilio.twiml.VoiceResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/call")
@RestController
class CallController {
    @RequestMapping(value = "/")
    fun helloSpringBoot() = "A nice looking call controller"

    @RequestMapping(value = "/forwardCall", produces = arrayOf("text/xml"))
    fun forwardCall(@RequestParam(value = "From") from: String): String {
        val call = Dial.Builder()
                .number(Number.Builder(System.getProperty("MY_NUMBER")).build())
                .build()
        return VoiceResponse.Builder()
                .dial(call).say(Say.Builder("You have a call from $from").voice(Say.Voice.ALICE).build())
                .build().toXml()
    }
}