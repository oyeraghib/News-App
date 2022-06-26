package com.example.newzu

import com.example.api.NewsAPIClient
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertNotNull

class NewsAPITest {

    val resp = NewsAPIClient.api

@Test
fun `get Top Headlines INDIA` () {

        runBlocking {
            val req = resp.getTopHeadlines()
            assertNotNull(req.body()?.articles)
        }
}
}


// Country codes <!-- in- India, us- USA, ru- Russia, kr- Korea, jp- Japan, nz- NewZealand -->

