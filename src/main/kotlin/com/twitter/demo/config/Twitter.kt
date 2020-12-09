package com.twitter.demo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.social.twitter.api.impl.TwitterTemplate

@Configuration
class Twitter {
    @Value("\${spring.social.twitter.appid}")
    lateinit var apiKey:String

    @Value("\${spring.social.twitter.appSecret}")
    lateinit var appSecret:String

    @Value("\${twitter.access.token}")
    lateinit var accessToken:String

    @Value("\${twitter.access.token.secret}")
    lateinit var accessTokenSecret:String

    @Bean
    fun twitterConfig():TwitterTemplate{
        return TwitterTemplate(apiKey,appSecret,accessToken,accessTokenSecret)
    }
}