package com.twitter.demo.controller

import com.twitter.demo.service.TwitterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.social.twitter.api.CursoredList
import org.springframework.social.twitter.api.SearchResults
import org.springframework.social.twitter.api.TwitterProfile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TwitterController {

    @Autowired
    lateinit var twitterService: TwitterService


    @GetMapping("/tweet",consumes = [MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getYourSearchedTweet(@RequestBody tweet:String): MutableList<Int> {
        return twitterService.getTweetsByHashtag(tweet)
 
    }

    @PostMapping("/unfollow",consumes=[MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getData(): String {
        return twitterService.unfollowNonFollowers()
    }
}