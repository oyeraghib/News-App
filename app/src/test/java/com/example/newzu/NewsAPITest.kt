package com.example.newzu

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class NewsAPITest {

    val resp = NewsAPIClient.api

    @Test
    fun `get Top Headlines INDIA`() {

        runBlocking {
            val req = resp.getTopHeadlines()
            assertNotNull(req.body()?.articles)
        }
    }
}


// Country codes <!-- in- India, us- USA, ru- Russia, kr- Korea, jp- Japan, nz- NewZealand -->

