package com.twitter.demo.config

import edu.stanford.nlp.pipeline.StanfordCoreNLP
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class NLPconfig {

    @Bean
    fun nlp():StanfordCoreNLP{
        val props=Properties()
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,parse,sentiment")

        return StanfordCoreNLP(props)
    }
}